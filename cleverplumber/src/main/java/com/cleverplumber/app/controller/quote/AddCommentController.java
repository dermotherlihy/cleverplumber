package com.cleverplumber.app.controller.quote;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.service.quote.QuoteManager;
import com.dermotherlihy.quotation.model.Comment;
import com.dermotherlihy.quotation.model.Quote;

@Controller
@RequestMapping(value = "/comment.do")
public class AddCommentController {

	@Autowired
	private QuoteManager quoteManager;
	
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
		return "quote/addQuoteComment";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String createComment(@RequestParam(required = true, value = "newComment") String commentText, Quote quote, HttpServletRequest request) {
	 
		String successView = "redirect:/comment.do?quote.id="+ quote.getId();
	
		if (request.getParameter("finish") != null) {
			quoteManager.sendQuoteEmail(quote);
			return "redirect:/viewQuote.do?id=" + quote.getId();
		}
		if(!isCommentTextValid(commentText, request)){
			 return "quote/addQuoteComment";
		}
		quoteManager.createQuoteComment(quote, commentText);
		return successView;
	}

	private boolean isCommentTextValid(String commentText, HttpServletRequest request) {
		if (!StringUtils.hasText(commentText))
		 {
		    request.setAttribute("commentError", "Please enter a comment");
		    return false;
		 }
		else if(commentText.length() > 100){
			 request.setAttribute("commentError", "Comment is too long");
			 return false;
		}
		return true;
	}
}
