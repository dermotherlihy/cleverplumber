package com.cleverplumber.app.controller.quote;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dermotherlihy.quotation.model.Quote;

@Controller
@RequestMapping(value = "/quotePDF.do")
public class ViewQuotePDFController {

	@ModelAttribute("quote")
	public Quote getQuote(@RequestParam(required = false, value = "id") Long quoteId) {
		Quote quote = null;
		if (quoteId != null) {
			quote = Quote.findQuote(quoteId);
		}
		return quote;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getView(Quote quote, Model model) {
		{
			Set<Quote> quoteList = new HashSet<Quote>();
			model.addAttribute(quoteList);
			return "viewQuotePDF";
		}
	}
}
