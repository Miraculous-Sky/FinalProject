package root.test;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {

	public static void main(String args[]) throws AddressException, MessagingException {
		sendHTML();
	}

	public static void sendHTML() throws AddressException, MessagingException {
		Properties mailServerProperties;
		Session getMailSession;
		MimeMessage mailMessage;
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "25");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		mailServerProperties.put("mail.mime.charset", "UTF-8");

		// Step2: get Mail Session
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		mailMessage = new MimeMessage(getMailSession);
		mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("vonguyenhuunhan@gmail.com"));
//	    generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); 
		mailMessage.setSubject("Xác thực tài khoản");
		String emailBody = "<p style='color: red'>Ê, đây là link xác thực tài khoản nèk!<p>";
		emailBody += "<a href='google.com'>Click vào đây nhanh cmnl</a>";
		mailMessage.setContent(emailBody, "text/html; charset=UTF-8");

		// Step3: Send mail
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", "nlu.cdw2020@gmail.com", "12345678A=a=");
		transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
		transport.close();
	}

}
