package com.cleverplumber.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cleverplumber.app.exception.ResourceNotFoundException;
import com.dermotherlihy.quotation.model.Customer;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

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

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Customer customer = Customer.findCustomer(id);
		if (customer == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(customer);
		return "customer/view";
	}

}
