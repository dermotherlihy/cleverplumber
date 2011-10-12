package com.cleverplumber.app.controller.quote;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.service.quote.QuoteManager;
import com.dermotherlihy.quotation.model.Comment;
@Controller
@RequestMapping(value = "/comment/delete.do")
public class DeleteCommentController {

	@Autowired
	private QuoteManager quoteManager;
	
	@ModelAttribute("quote.id")
	public Long getQuote(@RequestParam(required = false, value = "quote.id") Long quoteId) {
		return quoteId;
	}
	
	@ModelAttribute("comment")
	public Comment getComment(@RequestParam(required = false, value = "id") Long commentId) {
		Comment comment = null;
		if (commentId != null) {
			comment = Comment.findComment(commentId);
		}
		return comment;
	}


	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
	public String submitComment(Comment comment, BindingResult result, @RequestParam(required = true, value = "quote.id") Long quoteId, HttpServletRequest request, Model model) {
		String successUrl = "redirect:/comment.do?quote.id=" + quoteId;
		quoteManager.deleteQuoteComment(quoteId,comment);
		return successUrl;
	}
}
