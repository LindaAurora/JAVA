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

class Dependent {
    private Dependency dependency;

    public Dependent(Dependency dependency) {
        this.dependency = dependency;
    }

    public void doSomething() {
        dependency.setA(2);
        System.out.println(dependency.getA());
        dependency.doSomethingElse();
    }
}

class Dependency {
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void doSomethingElse() {
        System.out.println("El número es " + a);
    }
}