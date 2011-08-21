package com.cleverplumber.app.controller.company;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dermotherlihy.quotation.model.Company;

@Controller
@RequestMapping(value="/editCompany.do")
public class EditCompanyController {

		@ModelAttribute("company")
		public Company getCompany(@RequestParam(required = false, value = "id") Long companyId) {
			Company company = null;
			if (companyId != null) {
				company = Company.findCompany(companyId);
			}
			return company;
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
			return "redirect:/company.do?id"+company.getId();
		}
	}

