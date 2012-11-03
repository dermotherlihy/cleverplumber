
package com.cleverplumber.app.controller.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dermotherlihy.quotation.model.Customer;

@Controller
public class ViewCustomerController {

	@ModelAttribute("customer")
	public Customer getQuote(@RequestParam(required = false, value = "id") Long customerId) {
		Customer customer = null;
		if (customerId != null) {
			customer = Customer.findCustomer(customerId);
		}
		return customer;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/viewCustomer.do")
	public String getCustomer(Customer customer, Model model) {
		model.addAttribute(customer);
		return "customer/viewCustomer";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/viewCustomer/list.do")
	public String getCustomers(Model model) {
		List<Customer> customerList =  Customer.findAllCustomers();
		model.addAttribute("customerList",customerList );
		return "customer/customerList";
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/viewCustomerQuotes.do")
	public ModelAndView getCustomer(Customer customer, ModelAndView model) {
		model.addObject("quoteList", customer.getQuotes());
		model.setViewName("customer/viewQuotes");
		return model;
	}

}
