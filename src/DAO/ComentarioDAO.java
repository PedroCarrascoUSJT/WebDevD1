package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Comentario;

public class ComentarioDAO {
	
	public Comentario adicionarComentario(Comentario comentario) {
		comentario.setId(-1);
		String sql = "INSERT INTO Comentario VALUES(NULL, ?, ?, ?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, comentario.getNome());
			ps.setString(2, comentario.getTexto());
			ps.setInt(3, comentario.getFk_noticia_id());
			ps.execute();
			String returnId = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement psId = conn.prepareStatement(returnId);
					ResultSet rs = psId.executeQuery()){
				if(rs.next())
					comentario.setId(rs.getInt(1));
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return comentario;
	}
	

}
