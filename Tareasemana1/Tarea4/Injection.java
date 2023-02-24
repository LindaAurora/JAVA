public class Injection {
    public static void main(String[] args) {
        // Crear instancia del objeto dependiente
        Dependency dependency = new Dependency();

        // Crear instancia del objeto dependiente de la dependencia
        Dependent dependent = new Dependent(dependency);

        // Usar el objeto dependiente
        dependent.doSomething();
    }
}
///La clase dependent es un objeto que tiene una dependencia de la clase dependency
class Dependent {
    private Dependency dependency;

    public Dependent(Dependency dependency) {
        this.dependency = dependency;
    }
//Aqui se llama a los metodos SET y GET
    public void doSomething() {
        dependency.setA(2);
        System.out.println(dependency.getA());
        dependency.doSomethingElse();
    }
}
//Aqui la clase dependency tiene una variable de instancia llamada a
class Dependency {
    int a;
//La instancia se puede obtener y llamar a traves de getA y setA
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
//aqui se imprime un mensaje que incluye el valor de a
    public void doSomethingElse() {
        System.out.println("El número es " + a);
    }
}
