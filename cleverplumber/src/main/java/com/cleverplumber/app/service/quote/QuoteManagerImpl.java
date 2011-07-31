package com.cleverplumber.app.service.quote;

import com.dermotherlihy.quotation.model.Quote;

public class QuoteManagerImpl implements QuoteManager{

	public void createQuote(Quote quote) {
		quote.calculateVatAndTotal();
		quote.persist();
	}

}
