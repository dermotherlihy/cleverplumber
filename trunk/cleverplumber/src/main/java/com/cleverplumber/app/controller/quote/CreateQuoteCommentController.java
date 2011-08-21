package com.cleverplumber.app.controller.quote;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.service.email.EmailManager;
import com.dermotherlihy.quotation.model.Comment;
import com.dermotherlihy.quotation.model.Quote;

@Controller
@RequestMapping(value = "/comment.do")
public class CreateQuoteCommentController {

	@Autowired
	private EmailManager emailManager;
	
	@ModelAttribute("quote")
	public Quote getQuote(@RequestParam(required = false, value = "quote.id") Long quoteId) {
		Quote quote = null;
		if (quoteId != null) {
			quote = Quote.findQuote(quoteId);
		}
		return quote;
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
	    
		String successView = "redirect:/comment.do?quote.id="+ quote.getId();
	    
		if (result.hasErrors()) {
			return "addQuoteComment";
		}
		
		if (request.getParameter("finish") != null) {
			emailManager.sendEmail(quote);
			return "redirect:/viewQuote.do?id=" + quote.getId();
		}

		comment.setQuote(quote);
		comment.persist();
		return successView;
	}
}
