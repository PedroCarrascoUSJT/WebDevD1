package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Noticia;
import Service.NoticiaService;

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
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = 'UTF-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action = 'criarnoticia.do' method = 'POST'> ");
		out.println("<input type = 'text' name='descricao' placeholder = 'Descrição'><br>");
		out.println("<input type = 'text' name='titulo' placeholder = 'Título'><br>");
		out.println("<textarea name='texto' rows='5' cols='33'></textarea><br>");
		out.println("<button type='submit'>Adicionar noticia</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		Noticia noticia = new Noticia();
		noticia.setDescricao(request.getParameter("descricao"));
		noticia.setTitulo(request.getParameter("titulo"));
		noticia.setTexto(request.getParameter("texto"));
		
		noticia = new NoticiaService().criarNoticia(noticia);
		
		if(noticia.getId() < 1)
			response.sendRedirect("listarnoticias.do");
		else
			response.getWriter().append("Nova Noticia adicionada com id "+noticia.getId());
		
	}

}
