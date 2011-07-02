package com.cleverplumber.app.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cleverplumber.app.exception.ResourceNotFoundException;
import com.cleverplumber.app.propertyeditor.BigDecimalPropertyEditor;
import com.cleverplumber.app.propertyeditor.BrochureTypeEditor;
import com.cleverplumber.app.propertyeditor.QuoteTypeEditor;
import com.dermotherlihy.quotation.model.BrochureType;
import com.dermotherlihy.quotation.model.Company;
import com.dermotherlihy.quotation.model.Customer;
import com.dermotherlihy.quotation.model.Quote;
import com.dermotherlihy.quotation.model.QuoteType;

@Controller
@RequestMapping(value = "/quote")
public class QuoteController {

	@InitBinder
	public void initBinder(WebDataBinder binder)
	{
      binder.registerCustomEditor(BigDecimal.class, null, new BigDecimalPropertyEditor());
      binder.registerCustomEditor(QuoteType.class, null, new QuoteTypeEditor());
      binder.registerCustomEditor(BrochureType.class, null, new BrochureTypeEditor());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Quote());
		model.addAttribute("customerList", Customer.findAllCustomers());
		model.addAttribute("companyList", Company.findAllCompanys());
		model.addAttribute("quoteTypes", QuoteType.values());
		model.addAttribute("brochureTypes", BrochureType.values());
		return "quote/createForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Quote quote, BindingResult result) {
		if (result.hasErrors()) {
			return "quote/createForm";
		}
		quote.persist();
		return "redirect:/addQuoteComment/" + quote.getId();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Quote quote = Quote.findQuote(id);
		if (quote == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(quote);
		return "quote/view";
	}

}
