package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.NoticiaService;
import Model.Noticia;

/**
 * Servlet implementation class AtualizarNoticia
 */
@WebServlet("/atualizarnoticia.do")
public class AtualizarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		Noticia noticia = new NoticiaService().carregaNoticia(Integer.parseInt(id));
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = 'UTF-8'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action = 'atualizarnoticia.do' method = 'POST'> ");
		out.println("<input style='display:none;' type = 'text' name='id' value='"+id+"'><br>");
		out.println("<input type = 'text' name='descricao' value='"+noticia.getDescricao()+"' placeholder = 'Descrição'><br>");
		out.println("<input type = 'text' value='"+noticia.getTitulo()+"' name='titulo' placeholder = 'Título'><br>");
		out.println("<textarea name='texto' rows='5' cols='33'>"+noticia.getTexto()+"</textarea><br>");
		out.println("<button type='submit'>Adicionar noticia</button>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String descricao = request.getParameter("descricao");
		String titulo = request.getParameter("titulo");
		String texto = request.getParameter("texto");
		int id = Integer.parseInt(request.getParameter("id"));
		
		new NoticiaService().atualizarNoticia(new Noticia(id,descricao,titulo,texto));
		
		response.sendRedirect(request.getContextPath());
	}

}
