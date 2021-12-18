package projetoAnimes;

public class Episodio {

	private int numero;
	private String titulo;
	private double duracao;

	public Episodio() {
		this(0, "", 0.0);
	}

	public Episodio(int numero, String titulo, double duracao) {
		this.numero = numero;
		this.titulo = titulo;
		this.duracao = duracao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getDuracao() {
		return this.duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Episodio other = (Episodio) obj;
		if (numero != other.numero)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Episodio " + this.numero + ": \"" + this.titulo + "\" (duração: " + this.duracao + " min)";
	}

}
