package com.cleverplumber.app.service.quote;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dermotherlihy.quotation.model.Comment;
import com.dermotherlihy.quotation.model.Quote;

@Transactional(propagation = Propagation.REQUIRED)
public interface QuoteManager {
	public void createOrUpdateQuote(Quote quote);
	public void deleteQuote(Quote quote);
	public Quote getQuote(Long quoteId);
	public List<Quote> getAllQuotes();
	public void deleteQuoteComment(Long quoteId, Comment comment);
	public void createQuoteComment(Quote quote, String commentText);
	public void sendQuoteEmail(Quote quote);
	List<Quote> getQuotesForPastYear();
}
