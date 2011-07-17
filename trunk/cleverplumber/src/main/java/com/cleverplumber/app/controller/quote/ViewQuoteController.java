package com.cleverplumber.app.controller.quote;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.exception.ResourceNotFoundException;
import com.dermotherlihy.quotation.model.Quote;

@Controller
@RequestMapping(value = "viewQuote")
public class ViewQuoteController {
	
	@ModelAttribute("quote")
	public Quote getQuote(@RequestParam(required = false, value = "id") Long quoteId) {
		Quote quote = null;
		if (quoteId != null) {
			quote = Quote.findQuote(quoteId);
		}
		return quote;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Quote quote = Quote.findQuote(id);
		if (quote == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(quote);
		return "viewQuote";
	}
	

	@RequestMapping(value = "/pdf/{id}", method = RequestMethod.GET)
	public String getPDFView(@PathVariable Long id, Model model) {
		Quote quote = Quote.findQuote(id);
		if (quote == null) {
			throw new ResourceNotFoundException(id);
		}
		Set<Quote> quoteList = new HashSet<Quote>();
		quoteList.add(quote);
		model.addAttribute(quoteList);
		model.addAttribute("format", "pdf");
		return "viewQuotePDF";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getQuote(Quote quote, Model model) {
		model.addAttribute(quote);
		return "viewQuote";
	}
	
	@RequestMapping(value = "/list")
	public String getQuotes(Model model) {
		List<Quote> quoteList = Quote.findAllQuotes();
		model.addAttribute("quoteList", quoteList);
		return "quoteList";
	}

}
