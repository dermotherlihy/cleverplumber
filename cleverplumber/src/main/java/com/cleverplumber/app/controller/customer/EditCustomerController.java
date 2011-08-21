package com.cleverplumber.app.controller.customer;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dermotherlihy.quotation.model.Customer;

@Controller
@RequestMapping(value="/editCustomer.do")
public class EditCustomerController {

		@ModelAttribute("customer")
		public Customer getQuote(@RequestParam(required = false, value = "id") Long customerId) {
			Customer customer = null;
			if (customerId != null) {
				customer = Customer.findCustomer(customerId);
			}
			return customer;
		}
		
		@RequestMapping(method = RequestMethod.GET)
		public String getCustomer(Customer customer, Model model) {
			model.addAttribute(customer);
			return "customer/editCustomer";
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public String create(@Valid Customer customer, BindingResult result) {
			if (result.hasErrors()) {
				return "customer/editCustomer";
			}
			customer.persist();
			return "redirect:/viewCustomer/list.do";
		}
	}
