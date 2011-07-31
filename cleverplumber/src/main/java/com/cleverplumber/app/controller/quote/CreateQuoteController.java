package com.cleverplumber.app.controller.quote;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.propertyeditor.BigDecimalPropertyEditor;
import com.cleverplumber.app.propertyeditor.BrochureTypeEditor;
import com.cleverplumber.app.propertyeditor.QuoteTypeEditor;
import com.cleverplumber.app.service.quote.QuoteManager;
import com.dermotherlihy.quotation.model.BrochureType;
import com.dermotherlihy.quotation.model.Company;
import com.dermotherlihy.quotation.model.Customer;
import com.dermotherlihy.quotation.model.Quote;
import com.dermotherlihy.quotation.model.QuoteType;

@Controller
@RequestMapping(value = "newQuote")
public class CreateQuoteController {

	@Autowired
	private QuoteManager quoteManager;
	
	private String vatRate;
	
	
	@ModelAttribute("quote")
	public Quote getQuote(@RequestParam(required = false, value = "customer.id") Long customerId) {
		 Quote quote = new Quote();
		
		 if (customerId != null){
			 Customer customer = Customer.findCustomer(customerId);
			 quote.setCustomer(customer);
			 quote.setCompany(Company.findAllCompanys().get(0));
		 }
		 return quote;
		 
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(BigDecimal.class, null,
				new BigDecimalPropertyEditor());
		binder.registerCustomEditor(QuoteType.class, null,
				new QuoteTypeEditor());
		binder.registerCustomEditor(BrochureType.class, null,
				new BrochureTypeEditor());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Quote quote, Model model) {
		model.addAttribute(quote);
		model.addAttribute("quoteTypes", QuoteType.values());
		model.addAttribute("brochureTypes", BrochureType.values());
		return "createQuote";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Quote quote, BindingResult result) {
		if (result.hasErrors()) {
			return "createQuote";
		}
		quoteManager.createQuote(quote);
		return "redirect:/comment/" + quote.getId();
	}

	@Value("#{'${quote.vatRate}'}")
	public void setVatRate(String vatRate) {
		this.vatRate = vatRate;
	}

	
	
}
