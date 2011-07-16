package com.cleverplumber.app.controller.quote;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cleverplumber.app.exception.ResourceNotFoundException;
import com.dermotherlihy.quotation.model.Quote;

@Controller
@RequestMapping(value = "/quotePDF")
public class ViewQuotePDFController {

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		{
			Quote quote = Quote.findQuote(id);

			if (quote == null) {
				throw new ResourceNotFoundException(id);
			}

			Set<Quote> quoteList = new HashSet<Quote>();
			model.addAttribute(quoteList);
			return "viewQuotePDF";
		}
	}
}
