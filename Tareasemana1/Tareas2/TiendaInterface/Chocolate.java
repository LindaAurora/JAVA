package TiendaInterface;


import java.util.ArrayList;
import java.util.List;

class Chocolate {
    public static void main(String[] args) {
       List<Chocolateria> chocolates = new ArrayList<>();
       chocolates.add(new Chocolateamargo());
       chocolates.add(new Chocolatesemiamargo());
       chocolates.add(new Chocolateenvinado());
       chocolates.add(new Chocolatedulce());

for (Chocolateria chocolateria : chocolates){
   chocolateria.prepararchocolates();
}
   }
}
