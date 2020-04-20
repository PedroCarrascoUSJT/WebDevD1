package Model;

public class Noticia {
	
	private int id;
	private String descricao;
	private String titulo;
	private String texto;
	
	public Noticia(int id, String descricao, String titulo, String texto) {
		setId(id);
		setDescricao(descricao);
		setTitulo(titulo);
		setTexto(texto);
	}
	public Noticia() {}
	
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
