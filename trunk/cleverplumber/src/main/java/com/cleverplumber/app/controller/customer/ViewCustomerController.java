
package com.cleverplumber.app.controller.customer;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.exception.ResourceNotFoundException;
import com.dermotherlihy.quotation.model.Customer;

@Controller
@RequestMapping(value="viewCustomer")
public class ViewCustomerController {

	@ModelAttribute("customer")
	public Customer getQuote(@RequestParam(required = false, value = "id") Long customerId) {
		Customer customer = null;
		if (customerId != null) {
			customer = Customer.findCustomer(customerId);
		}
		return customer;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Customer customer = Customer.findCustomer(id);
		if (customer == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(customer);
		return "viewCustomer";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getCustomer(Customer customer, Model model) {
		model.addAttribute(customer);
		return "viewCustomer";
	}
	
	@RequestMapping(value = "/list")
	public String getCustomers(Model model) {
		List<Customer> customerList =  Customer.findAllCustomers();
		model.addAttribute("customerList",customerList );
		return "customerList";
	}
}
