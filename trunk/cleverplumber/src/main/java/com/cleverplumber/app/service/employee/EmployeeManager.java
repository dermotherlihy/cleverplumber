package com.cleverplumber.app.service.employee;

import com.dermotherlihy.quotation.model.Employee;

public interface EmployeeManager {

	public Employee findEmployeeByUserName(String username);
}
