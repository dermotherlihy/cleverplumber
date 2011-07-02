package com.cleverplumber.app.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;

public class BigDecimalPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		BigDecimal amount;
		try {
			amount = BigDecimal.valueOf(Double.parseDouble(text));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("value must to an numeric");
		}
		setValue(amount);
	}

	@Override
	public String getAsText() {

		Object value = getValue();
		if (value == null) {
			return "";
		}

		BigDecimal amount = (BigDecimal) value;

		return amount.toString();
	}

}
