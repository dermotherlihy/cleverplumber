package com.cleverplumber.app.controller.quote;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dermotherlihy.quotation.model.Comment;
import com.dermotherlihy.quotation.model.Quote;

@Controller
@RequestMapping(value = "/comment/edit.do")
public class EditCommentController {


	
	@ModelAttribute("comment")
	public Comment getComment(@RequestParam(required = false, value = "id") Long commentId) {
		Comment comment = null;
		if (commentId != null) {
			comment = Comment.findComment(commentId);
		}
		return comment;
	}

	@ModelAttribute("quote.id")
	public Long getQuote(@RequestParam(required = false, value = "quote.id") Long quoteId) {
		return quoteId;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String editComment(Comment comment, Quote quote,Model model) {
		model.addAttribute(quote);
		model.addAttribute(comment);
		return "quote/editQuoteComment";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitComment(Comment comment, BindingResult result, @RequestParam(required = true, value = "quote.id") Long quoteId, HttpServletRequest request, Model model) {
		String successUrl = "redirect:/comment.do?quote.id=" + quoteId;
		if (request.getParameter("cancel") != null) {
			return "redirect:/comment.do?quote.id=" + quoteId;
		}
		comment.persist();
		return successUrl;
	}
}
