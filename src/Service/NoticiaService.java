package Service;

import Model.Noticia;
import DAO.NoticiaDAO;
import java.util.*;

public class NoticiaService {
	NoticiaDAO noticiaDAO = new NoticiaDAO();
	
	public Noticia criarNoticia(Noticia noticia) {
		return noticiaDAO.criarNoticia(noticia);
	}
	
	public ArrayList<Noticia> listarTodasNoticias(){
		return noticiaDAO.listarTodasNoticias();
	}
	
	public Noticia carregaNoticia(int id) {
		return noticiaDAO.carregaNoticia(id);
	}
	
	public void excluirNoticia(int id) {
		noticiaDAO.excluirNoticia(id);
	}

	public void atualizarNoticia(Noticia noticia) {
		noticiaDAO.atualizarNoticia(noticia);
	}
}
