
 //Se crea la clase gato, en la cual declaro un tipo de dato para nombre y edad
public class Gato {
    private String nombre;
    private int edad;
    
   //Se crea la clase gato donde se declara que los datos son iguales

    public Gato(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
//Se crea un string llamado nombre que me returne el valor de nombre
    public String getNombre() {
        return nombre;
    }
  //Se crea un int llamado edad que me returne el valor de edad

    public int getEdad() {
        return edad;
    }
//Se declara el set nombre y set edad  para sobreescribir el dato de nombre y edad
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

