package DAO;

import java.sql.*;
import java.util.*;
import Model.Noticia;

public class NoticiaDAO {
	
	public Noticia criarNoticia(Noticia noticia) {
		noticia.setId(-1);
		String sql = "INSERT INTO Noticia VALUES(NULL, ?, ?, ?)";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, noticia.getDescricao());
			ps.setString(2, noticia.getTitulo());
			ps.setString(3, noticia.getTexto());
			ps.execute();
			String returnId = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement psId = conn.prepareStatement(returnId);
					ResultSet rs = psId.executeQuery()){
				if(rs.next())
					noticia.setId(rs.getInt(1));
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return noticia;
	}

}
