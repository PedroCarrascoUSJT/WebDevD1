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
import Service.NoticiaService;


/**
 * Servlet implementation class CarregarNoticia
 */
@WebServlet("/noticia.do")
public class CarregarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarregarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		Noticia noticia = new NoticiaService().carregaNoticia(id);
		
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset = 'UTF-8'>");
		out.println("</head>");
		
		out.println("<body>");
		if(noticia.getId() == -1) {
			System.out.println(noticia.getId());
			response.setStatus(500);
			response.getWriter().append("<p> Noticia não encontrada! </p>")
								.append("<img src = 'https://http.cat/404'>");
		}else {
			request.getSession().setAttribute("idNoticia", noticia.getId());
			out.println("<p style='font-size : 64px;font-weight : bold;'>Real News</p>");
			out.println("<p style='font-size : 64px;font-weight : bold;text-align : center'>"+noticia.getTitulo()+"</p>");
			out.println("<p style='font-size :32px;text-align : center'>"+noticia.getTexto()+"</p>");
			
			out.println("<div style='text-align : center'>");
			out.println("<form action='adicionarcomentario.do' method='POST'>");
			out.println("<input style='width : 200px;' type='text' name='nome' placeholder = 'seu nome'><br>");
			out.println("<textarea name='comentario' cols='150' rows='4' placeholder='Comentario'></textarea><br>");
			out.println("<button type='submit'>Enviar</button>");
			out.println("</form>");
			out.println("</div>");
		}
		
		out.println("</body>");
		
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
