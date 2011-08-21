package com.cleverplumber.app.controller.quote;

import java.math.BigDecimal;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.propertyeditor.BigDecimalPropertyEditor;
import com.cleverplumber.app.propertyeditor.BrochureTypeEditor;
import com.cleverplumber.app.propertyeditor.QuoteTypeEditor;
import com.cleverplumber.app.service.employee.EmployeeManager;
import com.cleverplumber.app.service.quote.QuoteManager;
import com.dermotherlihy.quotation.model.BrochureType;
import com.dermotherlihy.quotation.model.Company;
import com.dermotherlihy.quotation.model.Customer;
import com.dermotherlihy.quotation.model.Quote;
import com.dermotherlihy.quotation.model.QuoteType;

@Controller
@RequestMapping(value = "/newQuote.do")
public class CreateQuoteController {

	@Autowired
	private QuoteManager quoteManager;
	
	@Autowired
	private EmployeeManager employeeManager;
	
	@ModelAttribute("quote")
	public Quote getQuote(@RequestParam(required = false, value = "customer.id") Long customerId, Principal principal) {
		 Quote quote = new Quote();
		
		 if (customerId != null){
			 Customer customer = Customer.findCustomer(customerId);
			 quote.setCustomer(customer);
			 quote.setCompany(Company.findAllCompanys().get(0));
			 quote.setCreatedBy(employeeManager.findEmployeeByUserName(principal.getName()));
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
		return "redirect:/comment.do?quote.id=" + quote.getId();
	}


	
	
}
