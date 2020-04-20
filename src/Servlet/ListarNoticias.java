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
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ListarNoticias
 */
@WebServlet("/listarnoticias.do")
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
		for(Noticia noticia : noticias) {
			out.println("<a style = 'text-decoration : none; color : black;' href='noticia.do?id="+noticia.getId()+"'>");
			out.println("<div>");
			out.println("<p style='font-size : 32px;font-weight : bold;'>TITULO : "+noticia.getTitulo()+"</p>");
			out.println("<p style='font-size : 12px'>DESCRIÇÃO : "+noticia.getDescricao()+"</p>");
			out.println("ID : "+noticia.getId());
			out.println("</div>");
			out.println("</a><br>");
		}
		out.println("</body>");
		
		out.println("</html>");
	}

}
