package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Noticia;

/**
 * Servlet implementation class CriarNoticia
 */
@WebServlet("/criarnoticia.do")
public class CriarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("<meta charset = 'UTF-8'>")
							.append("<form action = '/criarnoticia.do' method = 'POST'> ")
							.append("<input type = 'text' name='descricao' placeholder = 'Descrição'><br>")
							.append("<input type = 'text' name='titulo' placeholder = 'Título'><br>")
							.append("<textarea name='texto' rows='5' cols='33'></textarea><br>")
							.append("<button type='submit'>Adicionar noticia</button>")
							.append("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
