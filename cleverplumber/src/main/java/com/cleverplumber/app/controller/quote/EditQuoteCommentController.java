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

@Controller
@RequestMapping(value = "/comment/edit.do")
public class EditQuoteCommentController {


	@ModelAttribute("comment")
	public Comment getComment(@RequestParam(required = false, value = "id") Long commentId) {
		Comment comment = null;
		if (commentId != null) {
			comment = Comment.findComment(commentId);
		}
		return comment;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String editComment(Comment comment, Model model) {
		model.addAttribute(comment);
		return "editQuoteComment";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitComment(Comment comment, BindingResult result, HttpServletRequest request, Model model) {

		String successUrl = "redirect:/comment.do?quote.id=" + comment.getQuote().getId();
		comment.persist();
		return successUrl;
	}
}
