package Service;

import Model.Comentario;
import DAO.ComentarioDAO;

public class ComentarioService {
	ComentarioDAO comentarioDAO = new ComentarioDAO();
	
	public Comentario adicionarComentario(Comentario comentario){
		return comentarioDAO.adicionarComentario(comentario);
	}
}
