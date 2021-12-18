package projetoAnimes;

import java.util.ArrayList;
import java.util.List;

public class Anime {
	
	private String nome;
	private List<Episodio> episodios;
	
	public Anime() {
		this("", new ArrayList<>());
	}
	
	public Anime(String nome, List<Episodio> episodios) {
		this.nome = nome;
		this.episodios = episodios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Episodio> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(List<Episodio> episodios) {
		this.episodios = episodios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Anime other = (Anime) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.nome + " - (" + this.episodios.size() + " episódios disponíveis)";
	}

}
