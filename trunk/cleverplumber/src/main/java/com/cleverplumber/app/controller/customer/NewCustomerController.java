package com.cleverplumber.app.controller.customer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dermotherlihy.quotation.model.Customer;

@Controller
@RequestMapping(value = "/newCustomer")
public class NewCustomerController {

	@Autowired
	private Validator validator;

	@RequestMapping(method = RequestMethod.GET)
	public String getCreateForm(Model model) {
		model.addAttribute(new Customer());
		return "customer/createForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@Valid Customer customer, BindingResult result) {
		validator.validate(customer, result);
		if (result.hasErrors()) {
			return "customer/createForm";
		}
		customer.persist();
		return "redirect:/customer/" + customer.getId();
	}
}
