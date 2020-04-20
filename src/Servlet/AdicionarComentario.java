package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.ComentarioService;
import Model.Comentario;

/**
 * Servlet implementation class AdicionarComentario
 */
@WebServlet("/adicionarcomentario.do")
public class AdicionarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarComentario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int idNoticia = (int) request.getSession().getAttribute("idNoticia");
		String nome = (String) request.getParameter("nome");
		String texto = (String) request.getParameter("comentario");
		
		if(idNoticia < 1) {
			response.sendRedirect("listarnoticias.do");
			return;
		}
		
		Comentario comentario = new ComentarioService().adicionarComentario(new Comentario(-1,nome,texto,idNoticia));
		
		if(comentario.getId() < 1) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset = 'UTF-8'>");
			out.println("</head>");
			out.println("<body>");
			out.println("Erro ao inserir comentário!");
			out.println("<img src='https://http.cat/500'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		
		response.sendRedirect("noticia.do?id="+idNoticia);
	}

}
