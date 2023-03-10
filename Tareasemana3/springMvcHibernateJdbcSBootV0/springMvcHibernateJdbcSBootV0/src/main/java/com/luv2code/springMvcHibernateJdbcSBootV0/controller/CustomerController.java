package com.luv2code.springMvcHibernateJdbcSBootV0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springMvcHibernateJdbcSBootV0.entity.Hogwarts;
import com.luv2code.springMvcHibernateJdbcSBootV0.service.CustomerService;

@Controller
@RequestMapping("/Hogwarts")
public class CustomerController {

	// need to inject our customer service
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listHogwarts(Model theModel) {
		
		// get customers from the service
		List<Hogwarts> Hogwarts = customerService.getHogwarts();
				
		// add the customers to the model
		theModel.addAttribute("hogwarts", Hogwarts);
		
		return "list-Hogwarts";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Hogwarts theHogwarts = new Hogwarts();
		
		theModel.addAttribute("Hogwarts", theHogwarts);
		
		return "Hogwarts-form";
	}
	
	@PostMapping("/saveHogwarts")
	public String saveHogwarts(@ModelAttribute("Hogwarts") Hogwarts theHogwarts) {
		
		// save the customer using our service
		customerService.saveHogwarts(theHogwarts);
		
		return "redirect:/Hogwarts/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("HogwartsId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Hogwarts theHogwarts = customerService.getHogwarts(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("Hogwarts", theHogwarts);
		
		// send over to our form		
		return "Hogwarts-form";
	}
	
	@GetMapping("/delete")
	public String deleteHogwarts(@RequestParam("HogwartsId") int theId) {
		
		// delete the customer
		customerService.deleteHogwarts(theId);
		
		return "redirect:/Hogwarts/list";
	}
}










