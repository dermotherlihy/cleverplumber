package com.cleverplumber.app.service.quote;

import org.springframework.transaction.annotation.Transactional;

import com.dermotherlihy.quotation.model.Quote;

@Transactional
public interface QuoteManager {
	public void createQuote(Quote quote);
}
