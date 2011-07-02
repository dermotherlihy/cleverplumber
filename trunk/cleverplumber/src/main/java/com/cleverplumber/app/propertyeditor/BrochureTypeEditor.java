package com.cleverplumber.app.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.dermotherlihy.quotation.model.BrochureType;

public class BrochureTypeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {

		Integer value = null;

		try {
			value = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("value must to an integer");
		}

		for (BrochureType brochureType : BrochureType.values()) {
			if (brochureType.getValue().equals(value)) {
				setValue(brochureType);
			}
		}
	}

	@Override
	public String getAsText() {

		Object value = getValue();
		if (value == null) {
			return "";
		}

		BrochureType brochureType = (BrochureType) value;

		return brochureType.getValue().toString();
	}

}
