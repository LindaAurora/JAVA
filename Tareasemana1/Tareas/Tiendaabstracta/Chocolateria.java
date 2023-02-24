package Tiendaabstracta;
//Se crea mi clase principal que es abstracta
abstract class Chocolateria {
    //se crea el metodo  abstracto prepararchocolates
    public void prepararchocolates() {
    }

}
//Se crea la clase abstract que hereda las caracteristicas de la clase padre Chocolateria
//De igual forma solo se llama el metodo prepararchocolates y al final
//es llamado para imprimirlo

class Chocolateamargo extends Chocolateria {
    public void prepararchocolates(){
        System.out.println("Preparando delicioso chocolate amargo");
        }

        }
class Chocolatesemiamargo extends Chocolateria{
    public void prepararchocolates(){
        System.out.println("Preparando delicioso chocolate semi amargo");

    }

}
class Chocolateenvinado extends Chocolateria{
    public void prepararchocolates(){
        System.out.println("Preparando delicioso chocolate envinado");

    }

}
class Chocolatedulce extends Chocolateria{
    public void prepararchocolates(){
        System.out.println("Preparando delicioso chocolate dulce");

    }

}