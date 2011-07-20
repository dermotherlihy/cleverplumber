package com.cleverplumber.app.service.email;

import com.dermotherlihy.quotation.model.Quote;

public interface EmailManager {

	public void sendEmail(Quote quote) throws RuntimeEmailException;
}
