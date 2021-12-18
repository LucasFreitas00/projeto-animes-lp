package projetoAnimes;

import java.io.IOException;

public interface SistemaDeAnimes {

	Anime pesquisarAnime(String nomeAnime) throws AnimeException;

	Episodio pesquisarEpisodio(String nomeAnime, String tituloEpisodio) throws AnimeException;

	Episodio pesquisarEpisodio(String nomeAnime, int numeroEpisodio) throws AnimeException;

	String exibirEpisodio(String nomeAnime, String tituloOuNumeroDoEpisodio) throws AnimeException;

	void cadastrarEpisodio(String nomeAnime, Episodio episodio) throws AnimeException;

	void removerEpisodio(String nomeAnime, String tituloOuNumeroDoEpisodio) throws AnimeException;

	void cadastrarAnime(Anime anime) throws AnimeException;

	void removerAnime(String nomeAnime) throws AnimeException;

	void recuperarDados() throws IOException;

	void salvarDados() throws IOException;
}
