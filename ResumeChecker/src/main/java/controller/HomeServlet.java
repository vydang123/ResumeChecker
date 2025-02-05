package controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatCompletionResult;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;

import model.ChatMessageRole;
import model.ModelEnum;


/**
 * Servlet implementation class HomeServlet
 */

@MultipartConfig
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String OPENAI_API_KEY = "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";
       
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
    
    private double getMatchPercentageUsingOpenAI(String resume, String jobDescription) {
    	String token = System.getenv(OPENAI_API_KEY);
    	OpenAiService service = new OpenAiService(token);

    	String prompt = "Compare the following resume and job description. " +
                "Give a percentage score (0 to 100) indicating how well the resume matches the job description.\n\n" +
                "Resume:\n" + resume + "\n\n" +
                "Job Description:\n" + jobDescription + "\n\n" +
                "Match Percentage:";

        List<ChatMessage> messages = new ArrayList<>();
        ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "You are a job matching assistant.");
        messages.add(systemMessage);

        // Create user message
        ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), prompt);
        messages.add(userMessage);

        // Request OpenAI API to generate a match percentage
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model(ModelEnum.GPT_3_5_TURBO_0301.getName())
                .messages(messages)
                .build();

        ChatCompletionResult result = service.createChatCompletion(chatCompletionRequest);
        String responseText = result.getChoices().get(0).getMessage().getContent();

        // Extract the match percentage from the response
        try {
            String matchPercentageStr = responseText.replaceAll("[^0-9.]", ""); // Extract numeric value
            return Double.parseDouble(matchPercentageStr);
        } catch (NumberFormatException e) {
            return 0.0; // Return 0 if parsing fails
        }
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
