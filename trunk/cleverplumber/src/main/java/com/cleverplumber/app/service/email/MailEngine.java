package com.cleverplumber.app.service.email;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class MailEngine {
	private final Log log = LogFactory.getLog(getClass());

	private MailSender mailSender;
	private VelocityEngine velocityEngine;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}

	public void sendHtmlAndPlainTextEmail(final String to, final String from, final String subject, final String plainTextMailTemplate,
			final Map model, final Map<String, InputStreamSource> attachmentMap) throws Exception {

		final String textPartStr = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, plainTextMailTemplate, model);

		((JavaMailSenderImpl) mailSender).send(new MimeMessagePreparator() {
			   public void prepare(MimeMessage mimeMessage) throws MessagingException {
				     MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				     message.setFrom(from);
				     message.setTo(to);
				     message.setSubject(subject);
				     message.setText(textPartStr, true);
				    
				     for (Iterator<Entry<String,InputStreamSource>> iterator = attachmentMap.entrySet().iterator(); iterator.hasNext();) {
							String attachmentName = iterator.next().getKey();
				    		final InputStreamSource attachment = attachmentMap.get(attachmentName);
				    		message.addAttachment(attachmentName, attachment);
					}
  				   }
				 });
		
	}

}
