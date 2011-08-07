package com.cleverplumber.app.controller.company;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.exception.ResourceNotFoundException;
import com.dermotherlihy.quotation.model.Company;

@Controller
@RequestMapping(value="editCompany")
public class EditCompanyController {

		@ModelAttribute("company")
		public Company getCompany(@RequestParam(required = false, value = "id") Long companyId) {
			Company company = null;
			if (companyId != null) {
				company = Company.findCompany(companyId);
			}
			return company;
		}
		
		@RequestMapping(value = "{id}", method = RequestMethod.GET)
		public String getView(@PathVariable Long id, Model model) {
			Company company = Company.findCompany(id);
			if (company == null) {
				throw new ResourceNotFoundException(id);
			}
			model.addAttribute(company);
			return "company/editCompany";
		}
		
		@RequestMapping(method = RequestMethod.GET)
		public String getCompany(Company company, Model model) {
			model.addAttribute(company);
			return "company/editCompany";
		}
		
	
		
		@RequestMapping(method = RequestMethod.POST)
		public String edit(@Valid Company company, BindingResult result) {
			if (result.hasErrors()) {
				return "company/editCompany";
			}
			company.persist();
			return "redirect:/company/"+company.getId();
		}
	}

