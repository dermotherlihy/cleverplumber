package com.cleverplumber.app.controller.quote;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dermotherlihy.quotation.model.Quote;

@Controller
public class ViewQuoteController {
	
	@ModelAttribute("quote")
	public Quote getQuote(@RequestParam(required = false, value = "id") Long quoteId) {
		Quote quote = null;
		if (quoteId != null) {
			quote = Quote.findQuote(quoteId);
		}
		return quote;
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
		return "viewQuote";
	}
	
	@RequestMapping(value = "/viewQuote/list.do")
	public String getQuotes(Model model) {
		List<Quote> quoteList = Quote.findAllQuotes();
		model.addAttribute("quoteList", quoteList);
		return "quoteList";
	}

}
