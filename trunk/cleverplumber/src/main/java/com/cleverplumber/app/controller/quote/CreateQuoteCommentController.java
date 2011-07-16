package com.cleverplumber.app.controller.quote;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dermotherlihy.quotation.model.Comment;
import com.dermotherlihy.quotation.model.Quote;

@Controller
@RequestMapping(value = "/comment/{quoteId}")
public class CreateQuoteCommentController {
	
	@ModelAttribute("quote")
	public Quote getQuote(@PathVariable Long quoteId) {
		return Quote.findQuote(quoteId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String addCommentToQuote(Quote quote, Model model) {
		Comment comment = new Comment();
		comment.setQuote(quote);
		model.addAttribute(comment);
		return "quote/addComment";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createComment(Comment comment, BindingResult result, Quote quote, HttpServletRequest request, Model model) {
		comment.setQuote(quote);
		comment.persist();
		quote.getComments().add(comment);
		model.addAttribute(quote);
		return "quote/addComment";
	}
}
