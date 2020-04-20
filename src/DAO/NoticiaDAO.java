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
	
	public ArrayList<Noticia> listarTodasNoticias(){
		ArrayList<Noticia> noticias = null;
		String sql = "SELECT * FROM noticia";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
			noticias = new ArrayList<Noticia>();
			while(rs.next()) {
				int id = rs.getInt(1);
				String descricao = rs.getString(2);
				String titulo = rs.getString(3);
				String texto = rs.getString(4);
				noticias.add(new Noticia(id,descricao,titulo,texto));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return noticias;
	}

}
