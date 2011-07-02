package com.cleverplumber.app.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.dermotherlihy.quotation.model.QuoteType;

public class QuoteTypeEditor extends PropertyEditorSupport{

	@Override
	public void setAsText(String text) {

		Integer value = null;

		try {
			value = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("value must to an integer");
		}

		for (QuoteType quoteType : QuoteType.values()) {
			if (quoteType.getValue().equals(value)) {
				setValue(quoteType);
			}
		}
	}

	@Override
	public String getAsText() {

		Object value = getValue();
		if (value == null) {
			return "";
		}

		QuoteType quoteType = (QuoteType) value;

		return quoteType.getValue().toString();
	}

}
