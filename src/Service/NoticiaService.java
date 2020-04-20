package Service;

import Model.Noticia;
import DAO.NoticiaDAO;

public class NoticiaService {
	NoticiaDAO noticiaDAO = new NoticiaDAO();
	
	public Noticia criarNoticia(Noticia noticia) {
		return noticiaDAO.criarNoticia(noticia);
	}

}
