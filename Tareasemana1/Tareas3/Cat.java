class Cat {
    // Variable estática que almacenará la única instancia de la clase Cat
    private static Cat instance = null;
    // Atributo que guarda el nombre del gato
    private String name;

    // Constructor privado de Cat
    private Cat(String name) {
        this.name = name;
    }

    // Método estático que devuelve la instancia única de Cat
    public static Cat getInstance(String name) {
        // Si instance es null, es decir, la instancia aún no ha sido creada,
        // se crea una nueva instancia de Cat con el nombre proporcionado en el parámetro name
        // y se asigna a la variable instance
        if (instance == null) {
            instance = new Cat(name);
        }
        // Se devuelve la instancia única de Cat
        return instance;
    }

    // Método que imprime un mensaje "Meow!" junto al nombre del gato
    public void meow() {
        System.out.println(name + " dice: Meow!");
    }

}
class Main {
    // Método Main
    public static void main(String args[])
    {
        //Inicializa Singleton class con la variable x
        Cat x = Cat.getInstance("Canela");

        //Inicializa Singleton class con la variable y
        Cat y = Cat.getInstance("Canelo");

        x.meow();
        y.meow();
    }
}