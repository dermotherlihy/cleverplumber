package com.cleverplumber.app.controller.quote;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.service.quote.QuoteManager;
import com.dermotherlihy.quotation.model.Quote;

@Controller
public class ViewQuoteController {
	
	@Autowired
	private QuoteManager quoteManager; 

	@ModelAttribute("quote")
	public Quote getQuote(@RequestParam(required = false, value = "id") Long quoteId) {
		return quoteManager.getQuote(quoteId);
	}

	@RequestMapping(value = "/viewQuote/pdf.do", method = RequestMethod.GET)
	public String getPDFView(Quote quote, Model model) {
		Set<Quote> quoteList = new HashSet<Quote>();
		quoteList.add(quote);
		model.addAttribute(quoteList);
		model.addAttribute("format", "pdf");
		return "viewQuotePDF";
	}
	
	@RequestMapping(value = "/viewQuote.do", method = RequestMethod.GET)
	public String getQuote(Quote quote, Model model) {
		model.addAttribute(quote);
		return "quote/viewQuote";
	}
	
	@RequestMapping(value = "/viewQuote/list.do")
	public String getQuotes(Model model) {
		@SuppressWarnings("unchecked")
		List<Quote> quoteList = quoteManager.getQuotesForLastThreeMonths();
		model.addAttribute("quoteList", quoteList);
		return "quote/quoteList";
	}

}
