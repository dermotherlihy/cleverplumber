package com.cleverplumber.app.domain.model;

import java.math.BigDecimal;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.dermotherlihy.quotation.model.Customer;

public class Quote {
	
	private Long id;
	
	@NotNull
	private Customer customer;
	
	@NotNull
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal labourAmount;
	
	@NotNull
	@NumberFormat(style=Style.CURRENCY)
	private BigDecimal materialsAmount;
	
	@NotNull
	private Set<Comment> quoteComments;
	
	
	public Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getLabourAmount() {
		return labourAmount;
	}

	public void setLabourAmount(BigDecimal labourAmount) {
		this.labourAmount = labourAmount;
	}

	public BigDecimal getMaterialsAmount() {
		return materialsAmount;
	}

	public void setMaterialsAmount(BigDecimal materialsAmount) {
		this.materialsAmount = materialsAmount;
	}

	public Set<Comment> getQuoteComments() {
		return quoteComments;
	}

	public void setQuoteComments(Set<Comment> quoteComments) {
		this.quoteComments = quoteComments;
	}

	public static AtomicLong getIdsequence() {
		return idSequence;
	}

	public Long assignId() {
		this.id = idSequence.incrementAndGet();
		return id;
	}
	
	private static final AtomicLong idSequence = new AtomicLong();
	
}
