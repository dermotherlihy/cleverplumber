package com.cleverplumber.app.domain.model;

public enum QuoteType {
	BOILER(0, "Boiler");
	private final int status;

	QuoteType(int aStatus, String decription) {
		this.status = aStatus;
	}

	public int status() {
		return this.status;
	}
}
