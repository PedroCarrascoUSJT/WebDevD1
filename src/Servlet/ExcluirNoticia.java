package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.NoticiaService;

/**
 * Servlet implementation class ExcluirNoticia
 */
@WebServlet("/excluirnoticia.do")
public class ExcluirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idNoticia = Integer.parseInt(request.getParameter("id"));
		new NoticiaService().excluirNoticia(idNoticia);
		
		response.getWriter().append(request.getContextPath());
	}

}
