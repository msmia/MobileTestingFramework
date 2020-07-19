package com.gobrightside.qa.util;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 
 * 
 * NOTE: Make sure you have an email, password, and a phone number. When you
 * sign up or sign in, the text will be sent to the phone number you've used. A
 * copy of the text message will then be sent to the gmail account the number is
 * associated with. The confirmation code will be parsed and returned.
 * 
 * Instantiate this class in the @BeforeMethod if you want this to run for
 * every @Test annotation.
 * 
 * @author sharif.mia
 *
 */

public class Email {

	boolean textIsHtml = false;
	String[] confirmationCode;
	Date emailTimeStamp;
	Date systemTimeStamp;
	String subject = null;
	Flag flag = null;
	Message[] msgs;
	Folder inbox;

	public Email() {
		try {
			systemTimeStamp = new Date();
			System.out.println("System time: " + systemTimeStamp);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String[] readConfirmationCode() {

		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "imaps");

		try {

			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect("imap.gmail.com", "gbside4testing001@gmail.com", "3bTest1234!@#$");

			inbox = store.getFolder("INBOX");

			inbox.open(Folder.READ_ONLY);

			waitForEmailToArrive();

			for (int i = inbox.getMessageCount() - 1; i >= 0; i--) {

				subject = msgs[i].getSubject().toString();

				emailTimeStamp = msgs[i].getSentDate();
				System.out.println("Email time: " + emailTimeStamp);

				if (subject.indexOf("New text message from") > -1) {
					if (emailTimeStamp.after(systemTimeStamp)) {
						String emailBodyHtml = getEmailBodyContent(msgs[i]);
						String text = parseHtml(emailBodyHtml);
						confirmationCode = splitConfirmationCodeFromHtml(text);
						System.out.println("Confirmation code found: " + c(confirmationCode));
						break;
					}
				}
			}
		} catch (Exception mex) {
			System.out.println(mex.getMessage());
		}
		return confirmationCode;
	}

	/**
	 * Parse the confirmation code form html
	 * 
	 * @param text
	 * @return
	 */
	private String[] splitConfirmationCodeFromHtml(String text) {
		String[] splitByStr = text.split("verification code is ");
		String[] splitBySpace = splitByStr[1].split(" ");
		String[] splitByPeriod = splitBySpace[0].split("\\.");
		confirmationCode = splitConfirmationCode(splitByPeriod[0].trim());
		return confirmationCode;
	}

	/**
	 * Return the primary text content of the message.
	 */
	private String getEmailBodyContent(Part p) throws MessagingException, IOException {

		if (p.isMimeType("text/*")) {
			String s = (String) p.getContent();
			textIsHtml = p.isMimeType("text/html");
			return s;
		}

		if (p.isMimeType("multipart/alternative")) {
			// prefer html text over plain text
			Multipart mp = (Multipart) p.getContent();
			String text = null;
			for (int i = 0; i < mp.getCount(); i++) {
				Part bp = mp.getBodyPart(i);
				if (bp.isMimeType("text/plain")) {
					if (text == null)
						text = getEmailBodyContent(bp);
					continue;
				} else if (bp.isMimeType("text/html")) {
					String s = getEmailBodyContent(bp);
					if (s != null)
						return s;
				} else {
					return getEmailBodyContent(bp);
				}
			}
			return text;
		} else if (p.isMimeType("multipart/*")) {
			Multipart mp = (Multipart) p.getContent();
			for (int i = 0; i < mp.getCount(); i++) {
				String s = getEmailBodyContent(mp.getBodyPart(i));
				if (s != null)
					return s;
			}
		}

		return null;
	}

	/**
	 * Split confirmation code character by character
	 * 
	 * @param splitConfirmationCode
	 * @return
	 */
	private String[] splitConfirmationCode(String splitConfirmationCode) {

		String[] strChar = null;

		try {
			strChar = splitConfirmationCode.split("(?!^)");
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		return strChar;
	}

	/**
	 * Parse HTML code
	 * 
	 * @param str
	 * @return
	 */
	private String parseHtml(String emailBodyHtml) {
		String html = emailBodyHtml;
		Document doc = Jsoup.parse(html);
		return doc.body().text();
	}

	/**
	 * Wait for the email to arrive
	 * 
	 * @throws MessagingException
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	private boolean waitForEmailToArrive() {

		boolean tf = false;

		try {

			while (!tf) {

				msgs = inbox.getMessages();
				subject = msgs[inbox.getMessageCount() - 1].getSubject().toString();
				emailTimeStamp = msgs[inbox.getMessageCount() - 1].getSentDate();

				if (emailTimeStamp.after(systemTimeStamp)) {
					if (subject.indexOf("New text message from") > -1) {
						tf = true;
					}
				} else {
					Thread.sleep(2000);
				}
			}
		} catch (MessagingException | InterruptedException e) {
			e.getMessage();
		}
		return tf;
	}

	private String c(String[] confirmationCode) {
		return confirmationCode[0] + confirmationCode[1] + confirmationCode[2] + confirmationCode[3]
				+ confirmationCode[4] + confirmationCode[5];
	}

}