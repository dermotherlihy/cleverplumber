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

@Controller
@RequestMapping(value = "/comment/edit/{id}")
public class EditQuoteCommentController {
	
	@ModelAttribute("comment")
	public Comment getComment(@PathVariable Long id) {
		return Comment.findComment(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String editComment(Comment comment,  Model model) {
		model.addAttribute(comment);
		return "quote/editComment";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitComment(Comment comment, BindingResult result, HttpServletRequest request, Model model) {
		String successUrl = "redirect:/comment/" + comment.getQuote().getId();
		comment = Comment.entityManager().merge(comment);
		System.out.println(comment.getText());
		return successUrl;
	}
}

