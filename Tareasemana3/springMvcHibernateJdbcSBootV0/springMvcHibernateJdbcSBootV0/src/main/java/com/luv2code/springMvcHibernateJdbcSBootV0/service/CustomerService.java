package com.luv2code.springMvcHibernateJdbcSBootV0.service;

import java.util.List;

import com.luv2code.springMvcHibernateJdbcSBootV0.entity.Hogwarts;

public interface CustomerService {

	public List<Hogwarts> getHogwarts();

	public void saveHogwarts(Hogwarts theHogwarts);

	public Hogwarts getHogwarts(int theId);

	public void deleteHogwarts(int theId);


	
}
