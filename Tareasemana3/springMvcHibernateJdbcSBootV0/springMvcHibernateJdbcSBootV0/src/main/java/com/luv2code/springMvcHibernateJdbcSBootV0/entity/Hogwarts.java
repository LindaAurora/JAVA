package com.luv2code.springMvcHibernateJdbcSBootV0.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Hogwarts")
public class Hogwarts {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private String edad;
	
	@Column(name="casa")
	private String casa;
	
	@Column(name="patronus")
	private String patronus;
	
	@Column(name="varita")
	private String varita;
	
	@Column(name="mascota")
	private String mascota;
	
	@Column(name="foto")
	private String foto;
	

		
}





