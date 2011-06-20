package com.cleverplumber.app.domain.model;

public enum BrochureType {
	BOILER1(0, "Boiler");
	private final int status;

	BrochureType(int aStatus, String decription) {
		this.status = aStatus;
	}

	public int status() {
		return this.status;
	}
}

