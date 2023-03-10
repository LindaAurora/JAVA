package com.luv2code.springMvcHibernateJdbcSBootV0.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springMvcHibernateJdbcSBootV0.dao.CustomerDAO;
import com.luv2code.springMvcHibernateJdbcSBootV0.entity.Hogwarts;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Hogwarts> getHogwarts() {
		return customerDAO.getHogwarts();
	}

	@Override
	@Transactional
	public void saveHogwarts(Hogwarts theHogwarts) {

		customerDAO.saveHogwarts(theHogwarts);
	}

	@Override
	@Transactional
	public Hogwarts getHogwarts(int theId) {
		
		return customerDAO.getHogwarts(theId);
	}

	@Override
	@Transactional
	public void deleteHogwarts(int theId) {
		
		customerDAO.deleteHogwarts(theId);
	}
}





