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
		ArrayList<Noticia> noticias = new ArrayList<Noticia>();
		String sql = "SELECT * FROM noticia";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()){
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
	
	public Noticia carregaNoticia(int id) {
		Noticia noticia = new Noticia();
		String sql = "SELECT * FROM noticia WHERE id = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					String descricao = rs.getString(2);
					String titulo = rs.getString(3);
					String texto = rs.getString(4);
					noticia = new Noticia(id,descricao,titulo,texto);
				}else {
					noticia.setId(-1);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return noticia;
	}
	
	public void excluirNoticia(int id) {
		String sql = "DELETE FROM Comentario WHERE fk_noticia_id = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setInt(1,id);
			String sqlNoticia = "DELETE FROM Noticia WHERE id = ?";
			try(PreparedStatement psNoticia = conn.prepareStatement(sqlNoticia)){
				psNoticia.setInt(1,id);
				psNoticia.execute();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizarNoticia(Noticia noticia) {
		String sql = "UPDATE Noticia SET descricao = ?, titulo = ?, texto = ? WHERE id = ?";
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, noticia.getDescricao());
			ps.setString(2, noticia.getTitulo());
			ps.setString(3, noticia.getTexto());
			ps.setInt(4, noticia.getId());
			ps.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
