package com.cleverplumber.app.controller.customer;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dermotherlihy.quotation.model.Customer;

@Controller
@RequestMapping(value = "customer")
public class NewCustomerController {

	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Customer());
		return "createCustomer";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			return "createCustomer";
		}
		customer.persist();
		return "redirect:/viewCustomer/list";
	}
}
