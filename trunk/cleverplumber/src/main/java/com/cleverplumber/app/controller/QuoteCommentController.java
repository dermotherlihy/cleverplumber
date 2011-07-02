package com.cleverplumber.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cleverplumber.app.exception.ResourceNotFoundException;
import com.dermotherlihy.quotation.model.Comment;
import com.dermotherlihy.quotation.model.Quote;


@Controller
@RequestMapping(value = "/addQuoteComment")
public class QuoteCommentController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String addCommentToQuote(@PathVariable Long id, Model model)
	   {
			Quote quote = Quote.findQuote(id);
			if (quote == null) {
				throw new ResourceNotFoundException(id);
			}
			model.addAttribute(quote);
			return "quote/addComment";
	}
	
	@RequestMapping(method = RequestMethod.POST)
   public String submitCommentToQuote(@RequestParam(required = false, value = "newComment") String comment, Quote quote, BindingResult result,
         HttpServletRequest request, Model model)
   {
	  String cancelView = "redirect:quote/addQuoteComment?id=" + quote.getId();
      if (request.getParameter("cancel") != null)
      {
         return cancelView;
      }
      if (StringUtils.isEmpty(comment))
      {
         request.setAttribute("commentError", "Please enter a comment");
         return "quote/addComment";
      }
      
      quote = Quote.findQuote(quote.getId());
	  
      Comment persistableComment = new Comment();
	  persistableComment.setText(comment);
	  persistableComment.setQuote(quote);
	  persistableComment.persist();
	  
	  quote.getComments().add(persistableComment);
	  model.addAttribute(quote);
	  return "quote/addComment";
 }
	 

}
