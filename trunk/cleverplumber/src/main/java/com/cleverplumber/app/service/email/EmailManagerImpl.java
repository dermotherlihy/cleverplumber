package com.cleverplumber.app.service.email;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;

import com.dermotherlihy.quotation.model.BrochureType;
import com.dermotherlihy.quotation.model.Quote;

public class EmailManagerImpl implements EmailManager {

	@Autowired
	private MailEngine mailEngine;
	
	private String emailFrom;
	
	private String subject;
	
	public void sendEmail(Quote quote) throws RuntimeEmailException {

		Set<Quote> quotes = new HashSet<Quote>();
		quotes.add(quote);
		ClassPathResource quoteResource = new ClassPathResource("quote.jrxml");

		byte[] bytes;
		try {
			JasperDesign jasperDesign = JRXmlLoader.load(quoteResource.getFile());
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(quotes));
			bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (JRException e1) {
			throw new RuntimeEmailException(e1.getMessage());
		} catch (IOException e1) {
			throw new RuntimeEmailException(e1.getMessage());
		}
		ByteArrayResource pdfInputStream = new ByteArrayResource(bytes);
		
		Map<String, InputStreamSource> attachmentMap = new HashMap<String, InputStreamSource>();
		attachmentMap.put("quote.pdf", pdfInputStream);
		addBrochureIfNeeded(quote, attachmentMap);
		addPublicLiabilityCertifcate(attachmentMap);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("quote", quote);

		try {
			mailEngine.sendHtmlAndPlainTextEmail(quote.getCustomer().getEmailAddress(), emailFrom, subject, "quote.vm", model,
					attachmentMap);
		} catch (Exception e) {
			throw new RuntimeEmailException(e.getMessage());
		}

	}

	private void addPublicLiabilityCertifcate(Map<String, InputStreamSource> attachmentMap) {
		ClassPathResource publicLiabilityCertificate = new ClassPathResource("public-liability-certificate.pdf");
		attachmentMap.put("public-liability-certificate.pdf", publicLiabilityCertificate);
	}

	private void addBrochureIfNeeded(Quote quote, Map<String, InputStreamSource> attachmentMap) {
			ClassPathResource attachmentResource = null;
			switch(quote.getBrochureType()){
			case WORCHESTER_BOILER:
				attachmentResource= new ClassPathResource("greenstar-gas-boiler-brochure.pdf");
				attachmentMap.put("greenstar-gas-boiler-brochure.pdf", attachmentResource);
				break;
			case VAILLIANT_BROCHURE:
				attachmentResource = new ClassPathResource("vaillaint.pdf");
				attachmentMap.put("vaillaint-consumer-brochure.pdf", attachmentResource);
				break;
			case GRUNDFOS_PUMP:
				attachmentResource = new ClassPathResource("grundfos-pump.pdf");
				attachmentMap.put("grundfos-pump-brochure.pdf", attachmentResource);
				break;
			default:
			}
	}
	
	
	public void setMailEngine(MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}
	
	@Value("#{'${email.from}'}")
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	@Value("#{'${email.subject}'}")
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
