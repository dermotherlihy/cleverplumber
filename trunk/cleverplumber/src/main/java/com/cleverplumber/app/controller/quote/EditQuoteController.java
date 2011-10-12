package com.cleverplumber.app.controller.quote;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.propertyeditor.BigDecimalPropertyEditor;
import com.cleverplumber.app.propertyeditor.BrochureTypeEditor;
import com.cleverplumber.app.propertyeditor.QuoteTypeEditor;
import com.cleverplumber.app.service.quote.QuoteManager;
import com.dermotherlihy.quotation.model.BrochureType;
import com.dermotherlihy.quotation.model.Quote;
import com.dermotherlihy.quotation.model.QuoteType;
@Controller
@RequestMapping(value = "/editQuote.do")
public class EditQuoteController {

	@Autowired
	private QuoteManager quoteManager;
	
	@ModelAttribute("quote")
	public Quote getQuote(@RequestParam(required = false, value = "id") Long quoteId) {
		 return Quote.findQuote(quoteId);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(BigDecimal.class, null,
				new BigDecimalPropertyEditor());
		binder.registerCustomEditor(QuoteType.class, null,
				new QuoteTypeEditor());
		binder.registerCustomEditor(BrochureType.class, null,
				new BrochureTypeEditor());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getEditForm(Quote quote, Model model) {
		model.addAttribute(quote);
		model.addAttribute("quoteTypes", QuoteType.values());
		model.addAttribute("brochureTypes", BrochureType.values());
		return "quote/editQuote";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String edit(@Valid Quote quote, BindingResult result, HttpServletRequest request, Model model) {
		if (result.hasErrors()) {
			return "quote/editQuote";
		}
		if (request.getParameter("cancel") != null) {
			model.addAttribute(quote);
			return "quote/viewQuote";
		}
		quoteManager.createOrUpdateQuote(quote);
		return "redirect:/comment.do?quote.id=" + quote.getId();
	}
}

