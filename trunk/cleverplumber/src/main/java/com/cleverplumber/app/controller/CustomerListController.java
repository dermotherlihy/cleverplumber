package com.cleverplumber.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dermotherlihy.quotation.model.Customer;

@Controller
@RequestMapping(value="/customerList")
public class CustomerListController {

	@RequestMapping(method=RequestMethod.GET)
	public String getCustomers(Model model) {
		List<Customer> customerList =  Customer.findAllCustomers();
		model.addAttribute("customerList",customerList );
		return "customer/customerList";
	}
}
