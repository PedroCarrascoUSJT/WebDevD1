package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.NoticiaService;
import Model.Noticia;
import java.util.*;
import java.io.PrintWriter;

/**
 * Servlet implementation class ListarNoticias
 */
@WebServlet("/")
public class ListarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarNoticias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		ArrayList<Noticia> noticias = new NoticiaService().listarTodasNoticias();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = 'UTF-8'>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<a href='criarnoticia.do'>Clique aqui para criar uma noticia</a>");
		if(noticias.size() > 0)
			for(Noticia noticia : noticias) {
				out.println("<a style = 'text-decoration : none; color : black;' href='noticia.do?id="+noticia.getId()+"'>");
				out.println("<div>");
				out.println("<p style='font-size : 32px;font-weight : bold;'>TITULO : "+noticia.getTitulo()+"</p>");
				out.println("<p style='font-size : 12px'>DESCRI��O : "+noticia.getDescricao()+"</p>");
				out.println("<a href='atualizarnoticia.do?id="+noticia.getId()+"' style='display : flex; float : right; top:30%;padding-left : 20px;padding-right : 20px; border : 1px solid #000'>Editar</a>");
				out.println("<a href='excluirnoticia.do?id="+noticia.getId()+"' style='display : flex; float : right; top:30%;padding-left : 20px;padding-right : 20px; border : 1px solid #000'>Excluir</a>");
				out.println("ID : "+noticia.getId());
				out.println("</div>");
				out.println("</a><br>");
				out.println("<hr/>");
			}
		else {
			out.println("<p>Nenhuma noticia adicionada </p>");
			out.println("<img src = 'https://http.cat/204'>");
		}
		out.println("</body>");
		
		out.println("</html>");
	}

}
