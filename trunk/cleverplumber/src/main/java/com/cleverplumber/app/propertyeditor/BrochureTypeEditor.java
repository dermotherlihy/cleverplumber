package com.cleverplumber.app.propertyeditor;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

import com.dermotherlihy.quotation.model.BrochureType;

public class BrochureTypeEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) {
		if (StringUtils.hasText(text)) {
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
		} else {
			setValue(BrochureType.NONE);
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
