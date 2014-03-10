package com.baseproject.util.utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtils {

	private static final String HOST_NAME = "<HOST_NAME_HERE>";
	private static final String EMAIL = "<EMAIL_HERE>";
	private static final String PASSWORD = "<PASSWORD_HERE>";

	public static void sendEmail(String subject, String message, String to) {
		try {
			Email email = new SimpleEmail();
			email.setHostName(HOST_NAME);
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(EMAIL, PASSWORD));
			email.setSSLOnConnect(true);
			email.setFrom(EMAIL);
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(to);
			email.send();
		} catch (EmailException e) {
			throw new RuntimeException(e);
		}
	}
}
