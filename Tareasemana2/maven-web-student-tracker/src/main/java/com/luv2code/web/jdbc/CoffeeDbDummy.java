package com.luv2code.web.jdbc;

import java.util.ArrayList;
import java.util.List;

public class CoffeeDbDummy {

	static List<Coffee> coffees = new ArrayList<>();
	static int idContador;

	CoffeeDbDummy() {
		coffees.add(new Coffee(++idContador, "Latte","vainilla", "$40" ));
		coffees.add(new Coffee(++idContador, "Caramel Machiatto", "avellana", "$50"));
		coffees.add(new Coffee(++idContador, "Capuccino", "chips", "$30"));
	}

	public List<Coffee> getCoffees() throws Exception {
		return coffees;
	}

	public void addCoffee(Coffee theCoffee) throws Exception {
		theCoffee.setId(++idContador);
		coffees.add(theCoffee);
	}

	public Coffee getCoffee(String theCoffeeId) throws Exception {
		for (Coffee e : coffees) {
			if (e.getId() == Integer.valueOf(theCoffeeId)) {
				return e;
			}
		}
		return null;
	}

	public void updateCoffee(Coffee elCafe) throws Exception {		
		for (Coffee e : coffees) {
			if (e.getId() == elCafe.getId()) {
				e.setName(elCafe.getName());
				e.setToppings(elCafe.getToppings());
				e.setPrice(elCafe.getPrice());
			}
		}
	}

//	//NO FUNCIONA
//	public void updateStudent(Student elEstudiante) throws Exception {
//		for (Student e : students) {
//			if (e.getId() == elEstudiante.getId()) {
//				e = elEstudiante;
//			}
//		}
//	}

	public void deleteCoffee(String theCoffeeId) throws Exception {

		for (Coffee e : coffees) {
			if (e.getId() == Integer.valueOf(theCoffeeId)) {
				coffees.remove(e);
				return;
			}
		}
		
	}
}
