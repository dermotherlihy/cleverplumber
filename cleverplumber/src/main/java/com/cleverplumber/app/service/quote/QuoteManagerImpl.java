package com.cleverplumber.app.service.quote;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cleverplumber.app.service.email.EmailManager;
import com.dermotherlihy.quotation.model.Comment;
import com.dermotherlihy.quotation.model.Quote;

public class QuoteManagerImpl implements QuoteManager {

	@Autowired
	private EmailManager emailManager;
	

	public void createOrUpdateQuote(Quote quote) {
		quote.calculateVatAndTotal();
		if (quote.getId() == null) {
			quote.persist();
		} else {
			quote.merge();
		}
	}

	public Quote getQuote(Long quoteId) {
		Quote quote = null;
		if (quoteId != null) {
			quote = Quote.findQuote(quoteId);
		}
		return quote;

	}
	
	public List<Quote> getQuotesForPastYear(){
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, -1);
		return Quote.entityManager().createNamedQuery("Quote.byDate").setParameter(1, c.getTime()).setParameter(2, new Date()).getResultList();
	}

	public void deleteQuoteComment(Long quoteId, Comment comment) {
		comment.setQuote(Quote.findQuote(quoteId));
		comment.remove();
	}

	public void createQuoteComment(Quote quote, String commentText) {
		Comment comment = new Comment();
		comment.setText(commentText);
		comment.setQuote(quote);
		comment.persist();
	}

	public void sendQuoteEmail(Quote quote) {
		emailManager.sendEmail(quote);
	}

	public void deleteQuote(Quote quote) {
		quote.remove();
	}

	public List<Quote> getAllQuotes() {
		return Quote.findAllQuotes();
	}

}
