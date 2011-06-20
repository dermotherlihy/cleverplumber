package com.cleverplumber.app.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cleverplumber.app.domain.model.Quote;
import com.cleverplumber.app.exception.ResourceNotFoundException;
import com.dermotherlihy.quotation.model.Customer;

@Controller
@RequestMapping(value="/quote")
public class QuoteController {

	private Map<Long, Quote> quotes = new ConcurrentHashMap<Long, Quote>();
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Quote());
		model.addAttribute("customerList", Customer.findAllCustomers());
		return "quote/createForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid Quote quote, BindingResult result) {
		if (result.hasErrors()) {
			return "quote/createForm";
		}
		this.quotes.put(quote.assignId(), quote);
		return "redirect:/quote/" + quote.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Quote account = this.quotes.get(id);
		if (account == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(account);
		return "quote/view";
	}

}
