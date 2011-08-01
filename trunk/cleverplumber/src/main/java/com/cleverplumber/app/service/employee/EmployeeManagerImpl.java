package com.cleverplumber.app.service.employee;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import com.dermotherlihy.quotation.model.Employee;

public class EmployeeManagerImpl implements UserDetailsManager, EmployeeManager {

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		try {
			return (Employee) Employee.entityManager().createNamedQuery("Employee.findByUserName").setParameter(1, username).getSingleResult();
		} catch (Exception e) {
			throw new UsernameNotFoundException("Person with loginname : '" + username + "' not found...");
		}
	}
	
	public Employee findEmployeeByUserName(String username) {
		try {
			return (Employee) Employee.entityManager().createNamedQuery("Employee.findByUserName").setParameter(1, username).getSingleResult();
		} catch (Exception e) {
			throw new UsernameNotFoundException("Person with loginname : '" + username + "' not found...");
		}
	}

	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}



}
