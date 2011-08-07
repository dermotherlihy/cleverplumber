package com.cleverplumber.app.controller.quote;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cleverplumber.app.service.email.EmailManager;
import com.dermotherlihy.quotation.model.Comment;
import com.dermotherlihy.quotation.model.Quote;

@Controller
@RequestMapping(value = "/comment/{quoteId}")
public class CreateQuoteCommentController {

	@Autowired
	private EmailManager emailManager;
	
	
	@ModelAttribute("quote")
	public Quote getQuote(@PathVariable Long quoteId) {
		return Quote.findQuote(quoteId);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String addCommentToQuote(Quote quote, Model model) {
		Comment comment = new Comment();
		comment.setQuote(quote);
		model.addAttribute(comment);
		return "addQuoteComment";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createComment(@Valid Comment comment, BindingResult result, Quote quote, HttpServletRequest request) {
	    
		String successView = "redirect:/comment/"+ quote.getId();
	    
		if (result.hasErrors()) {
			return "addQuoteComment";
		}
		
		if (request.getParameter("finish") != null) {
			emailManager.sendEmail(quote);
			return "redirect:/viewQuote/" + quote.getId();
		}

		comment.setQuote(quote);
		comment.persist();
		return successView;
	}
}
