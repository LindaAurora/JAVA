package pokemonlambdas;
public class Pokemon {

    public String nombre;
    public String tipo;
    public int nivel;
    public int defensa;

    public Pokemon(String nombre, String tipo, int nivel, int defensa) {
        this.setNombre(nombre);
        this.setTipo(tipo);
        this.setNivel(nivel);
        this.setDefensa(defensa);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
        return "Pokémon: " + nombre + "\n" + "Tipo: " + tipo + "\n" + "Nivel: " + nivel + "\n" + "Defensa: " + defensa + "\n";
    }
}