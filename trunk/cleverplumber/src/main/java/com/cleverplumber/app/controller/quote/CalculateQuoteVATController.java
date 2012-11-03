package com.cleverplumber.app.controller.quote;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dermotherlihy.quotation.model.BrochureType;
import com.dermotherlihy.quotation.model.Quote;
import com.dermotherlihy.quotation.model.QuoteType;

public class CalculateQuoteVATController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Quote quote, Model model) {
		model.addAttribute(quote);
		model.addAttribute("quoteTypes", QuoteType.values());
		model.addAttribute("brochureTypes", BrochureType.values());
		return "quote/createQuote";
	}
}
