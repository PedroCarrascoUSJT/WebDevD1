package Model;

public class Comentario {
	private int id;
	private String nome;
	private String texto;
	private int fk_noticia_id;
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public int getFk_noticia_id() {
		return fk_noticia_id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public void setFk_noticia_id(int fk_noticia_id) {
		this.fk_noticia_id = fk_noticia_id;
	}
	
	

}
