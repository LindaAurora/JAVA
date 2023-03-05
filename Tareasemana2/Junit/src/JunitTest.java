

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class JunitTest {
    
	//En esta prueba se crea el objeto gato, se compara que ambos datos sean iguales (nombre)
    @Test
    public void testGetNombre() {
        Gato gato = new Gato("Stich", 3);
        assertEquals("Stich", gato.getNombre());
    }
    
	//En esta prueba se crea el objeto gato, se compara que ambos datos sean iguales (edad)

    @Test
    public void testGetEdad() {
        Gato gato = new Gato("Bonifacio", 5);
        assertEquals(5, gato.getEdad());
       
    }
    
    //Verificamos que sea verdadero la cantidad de caracteres del string gatito sea mayor a 5
    @Test
    public void lenght_greater_than_zero() {
    	assertTrue("Gatito".length() >5);
    }
    
    //Se declara un string gato (Morfeo) y se verifica que la cantidad de caracteres sea mayor a 5
    @Test
    public void lenght_greater() {
    	String gato = "Morfeo";
    	assertTrue(gato.length() >5);
    }
    
    //Verificamos que sea verdadero la cantidad de caracteres de Morfeo sea mayor a 5 

    @Test
    public void lenght() {
    
    	assertTrue("Morfeo".length() >5);
    }
    
    
    //Se crea un objeto con valores definidos, sobreescribo el nombre de gato y se comparan valores
    @Test
    public void testSetNombre() {
        Gato gato = new Gato("Morfeo", 2);
        gato.setNombre("Hades");
        assertEquals("Hades", gato.getNombre());
    }
    
    //Se crea un objeto con valores definidos, sobreescribo la edad de gato y se comparan valores

    @Test
    public void testSetEdad() {
        Gato gato = new Gato("Canela", 1);
        gato.setEdad(2);
        assertEquals(2, gato.getEdad());
    }
    
    //Se declara un string con valor null, y se espera una excepcion 
	@Test
    public void Gato_Null() {
    	String gato = null;
    	assertThrows(NullPointerException.class, () -> gato.length());
    }
	
	//Se declaara el objeto Gato con valores definidos, estoy comparando que si gato no esta vacio sea verdadero
	//Estoy comparando valores salem = salem nombre
	//Estoy comparando valores 4 = 4 edad
	@Test
	public void testCreateGato() {
	    Gato gato = new Gato("Salem", 4);
	    assertNotNull(gato);
	    assertEquals("Salem", gato.getNombre());
	    assertEquals(4, gato.getEdad());
	}
	
	//Se crea el objeto gato con valores definidos
	//Estoy comparando que si gato no esta vacio la prueba es correcta
	//Ahora sobreescribo el valor de gato que es igual a Null
	//Estoy comparando que el valor de gato esta vacio y mi prueba sea correcta
	@Test
	public void testDeleteGato() {
	    Gato gato = new Gato("Mimi", 6);
	    assertNotNull(gato);
	    gato = null;
	    assertNull(gato);
	}
	
	//Se crea el objeto gato con valores definidos
	//Estoy diciendo que si la edade de gato es mayor a 0 mi prueba es correcta
	@Test
	public void testAgeGreaterThanZero() {
	    Gato gato = new Gato("Garfield", 1);
	    assertTrue(gato.getEdad() > 0);
	}
	
	//Se crea el objeto con valores definidos
	//Estoy diciendo que el objeto gato no este vacio mi prueba sea correcta
	//Estoy comparando el string Milo sea igual a Milo
	//Estoy comparando el string 3 sea igual a 3 (edad)
	//Estoy sobreescribiendo el valor de nombre
	//Estoy sobreescribiendo el valor de edad
	//Estoy comparando simba tiene el mismo valor que getnombre
	//Estoy comparando 4 tiene el mismo valor que get edad 
	@Test
	public void testUpdateGato() {
	    Gato gato = new Gato("Milo", 3);
	    assertNotNull(gato);
	    assertEquals("Milo", gato.getNombre());
	    assertEquals(3, gato.getEdad());
	    gato.setNombre("Simba");
	    gato.setEdad(4);
	    assertEquals("Simba", gato.getNombre());
	    assertEquals(4, gato.getEdad());
	}
}

