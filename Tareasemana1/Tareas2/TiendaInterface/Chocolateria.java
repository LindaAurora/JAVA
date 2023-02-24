package TiendaInterface;
//Se crea mi clase principal que es abstracta
 interface  Chocolateria {
    //se crea el metodo  abstracto prepararchocolates
    void prepararchocolates();


}
//Se crea la clase abstract que hereda las caracteristicas de la clase padre Chocolateria
//De igual forma solo se llama el metodo prepararchocolates y al final
//es llamado para imprimirlo

class Chocolateamargo implements Chocolateria {
    public void prepararchocolates(){
        System.out.println("Preparando delicioso chocolate amargo");
        }

        }
class Chocolatesemiamargo implements Chocolateria{
   public void prepararchocolates(){
        System.out.println("Preparando delicioso chocolate semi amargo");

    }

}
class Chocolateenvinado implements Chocolateria{
    public void prepararchocolates(){
        System.out.println("Preparando delicioso chocolate envinado");

    }

}
class Chocolatedulce implements Chocolateria{
     public void prepararchocolates(){
        System.out.println("Preparando delicioso chocolate dulce");

    }

}