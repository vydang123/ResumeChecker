package model;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtils {
	private static final String EMAIL = "resumechecker.do.not.reply@gmail.com";
    private static final String PASSWORD = "eqnmysqlpdjiwjcs";
    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";

    public static void sendEmail(String recipient, String subject, String message) {
    	System.out.println("Preparing to send emails");
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);

        Session session = Session.getInstance(props, new Authenticator() {
        	@Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, PASSWORD);
            }
        });

        try {
        	System.out.println("Half way through...");
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(EMAIL));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            msg.setSubject(subject);
            msg.setText(message);

            Transport.send(msg);
            System.out.println("Messages sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
