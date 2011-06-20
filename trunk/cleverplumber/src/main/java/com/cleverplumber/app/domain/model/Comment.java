package com.cleverplumber.app.domain.model;

import java.util.concurrent.atomic.AtomicLong;

public class Comment {

	private Long id;

	private Quote quote;

	private String comments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public static AtomicLong getIdsequence() {
		return idSequence;
	}

	private static final AtomicLong idSequence = new AtomicLong();

}
