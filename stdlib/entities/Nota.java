package entities;

public class Nota {

	public String titulo;
	public String descripcion;

	public Nota(String titulo, String descripcion) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Nota [titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}

}
