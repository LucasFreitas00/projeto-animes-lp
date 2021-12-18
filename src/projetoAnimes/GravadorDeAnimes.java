package projetoAnimes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GravadorDeAnimes {

	private String localDosArquivos;

	public GravadorDeAnimes() {
		this("");
	}

	public GravadorDeAnimes(String localDosArquivos) {
		this.localDosArquivos = localDosArquivos;
	}

	public String getLocalDosArquivos() {
		return this.localDosArquivos;
	}

	public void setLocalDosArquivos(String localDosArquivos) {
		this.localDosArquivos = localDosArquivos;
	}

	public List<Anime> recuperarAnimes() throws IOException {
		List<Anime> listaDeAnimes = new ArrayList<>();
		File diretorio = new File(this.localDosArquivos);
		File[] arquivosAnimes = diretorio.listFiles();

		for (File file : arquivosAnimes) {
			Anime anime = new Anime();
			String nomeAnime = file.getName().replace(".txt", "");
			anime.setNome(nomeAnime);

			if (file.length() == 0) {
				listaDeAnimes.add(anime);
				continue;
			}

			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(this.localDosArquivos + "\\" + file.getName()));
				String linha = br.readLine();

				while (linha != null) {
					String[] dados = linha.split("#");
					int numeroDoEpisodio = Integer.parseInt(dados[0]);
					String tituloDoEpisodio = dados[1];
					double duracaoDoEpisodio = Double.parseDouble(dados[2]);
					Episodio episodio = new Episodio(numeroDoEpisodio, tituloDoEpisodio, duracaoDoEpisodio);
					anime.getEpisodios().add(episodio);
					linha = br.readLine();
				}
				listaDeAnimes.add(anime);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} finally {
				if (br != null) {
					br.close();
				}
			}
		}
		return listaDeAnimes;
	}

	public void salvarAnimes(List<Anime> animes) throws IOException {
		File diretorio = new File(this.localDosArquivos);

		if (diretorio.isDirectory()) {
			File[] arquivosAnimes = diretorio.listFiles();
			for (File file : arquivosAnimes) {
				file.delete();
			}
		}

		for (Anime a : animes) {
			File diretorioAnime = new File(this.localDosArquivos + "\\" + a.getNome() + ".txt");
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(diretorioAnime.getPath()));
				for (Episodio ep : a.getEpisodios()) {
					String dados = ep.getNumero() + "#" + ep.getTitulo() + "#" + ep.getDuracao();
					bw.write(dados);
					bw.newLine();
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
			if (a.getEpisodios().size() == 0) {
				diretorioAnime.mkdir();
			}
		}
	}
}
