package Service;

import Model.Comentario;
import DAO.ComentarioDAO;
import java.util.*;

public class ComentarioService {
	ComentarioDAO comentarioDAO = new ComentarioDAO();
	
	public Comentario adicionarComentario(Comentario comentario){
		return comentarioDAO.adicionarComentario(comentario);
	}
	
	public ArrayList<Comentario> carregarComentarioDaNoticia(int idNoticia){
		return comentarioDAO.carregarComentarioDaNoticia(idNoticia);
	}
}
