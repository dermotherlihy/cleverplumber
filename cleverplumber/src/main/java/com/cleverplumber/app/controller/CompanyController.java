package com.cleverplumber.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cleverplumber.app.exception.ResourceNotFoundException;
import com.dermotherlihy.quotation.model.Company;

@Controller
@RequestMapping(value="company")
public class CompanyController {

	@RequestMapping(method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		List<Company> companies = Company.findAllCompanys();
		if(Company.findAllCompanys().size() > 0){
			model.addAttribute(companies.get(0));
			return "viewCompany";
		}else{
			model.addAttribute(new Company());
			return "createCompany";
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid Company company, BindingResult result) {
		if (result.hasErrors()) {
			return "createCompany";
		}
		company.persist();
		return "redirect:company/" + company.getId();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getView(@PathVariable Long id, Model model) {
		Company company = Company.findCompany(id);
		if (company == null) {
			throw new ResourceNotFoundException(id);
		}
		model.addAttribute(company);
		return "viewCompany";
	}

}
