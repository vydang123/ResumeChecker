package controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;


/**
 * Servlet implementation class HomeServlet
 */

@MultipartConfig
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final String OPENAI_API_KEY = "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";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

    private String extractTextFromPDF(InputStream inputStream) throws IOException {
    	PDDocument document = null;
        try {
            document = PDDocument.load(inputStream);
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            System.out.println(text);
            return text;
        } finally {
            if (document != null) {
                document.close();  // Ensures the PDF is properly closed
            }
            inputStream.close();
        }
    }
    
    private double getMatchPercentageUsingOpenAI(String resumeText, String jobDescription) {
        OpenAiService service = new OpenAiService(OPENAI_API_KEY);
        
        String prompt = "Given the following resume text and job description, calculate the match percentage based on skills, experience, and qualifications. " +
                        "Provide only a numeric percentage value without additional text.\n\n" +
                        "Resume:\n" + resumeText + "\n\n" +
                        "Job Description:\n" + jobDescription;

        List<ChatMessage> messages = new ArrayList<>();
        messages.add(new ChatMessage("system", "You are a helpful AI assistant."));
        messages.add(new ChatMessage("user", prompt));
        
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-4")
                .messages(messages)
                .maxTokens(50)
                .temperature(0.7)
                .build();
        
        ChatCompletionResult result = service.createChatCompletion(request);
        
        if (result != null && !result.getChoices().isEmpty()) {
            String responseText = result.getChoices().get(0).getMessage().getContent().trim();
            try {
                return Double.parseDouble(responseText.replace("%", ""));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0.0;
         

        
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		try {
	        // Get the uploaded resume and job description
	        Part filePart = request.getPart("resume");
	        if (filePart == null) {
	            throw new ServletException("No file uploaded.");
	        }

	        String jobDescription = request.getParameter("jobDescription");
	        System.out.println(jobDescription);
	        if (jobDescription == null || jobDescription.trim().isEmpty()) {
	            throw new ServletException("Job description is required.");
	        }

	        // Extract text from the uploaded PDF
	        String resumeText = extractTextFromPDF(filePart.getInputStream());

	        // Get match percentage using OpenAI API
	        double matchPercentage = getMatchPercentageUsingOpenAI(resumeText, jobDescription);

	        // Pass the result to the JSP page
	        request.setAttribute("matchPercentage", matchPercentage);
	        request.getRequestDispatcher("index.jsp").forward(request, response);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
