package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.*;
import Model.*;
import java.util.*;
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
		
		ArrayList<Comentario> comentarios = new ComentarioService().carregarComentarioDaNoticia(id);
		
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
			out.println("<h1 style='font-size : 42px;font-weight : bold;'>Real News</h1>");
			out.println("<hr/>");
			out.println("<p style='font-size : 32px;font-weight : bold;padding-left:20px;'>"+noticia.getTitulo()+"</p>");
			out.println("<p style='font-size :24px;padding-left:20px;'>"+noticia.getTexto()+"</p>");
			
			if(comentarios.size()>0) {
				out.println("<div>");
				out.println("<p style='font-size:32px;padding-left:20px;'>Comentários</p>");
				for(Comentario comentario : comentarios) {
					out.println("<div>");
					out.println("<p style='font-size:16px;padding-left:25px;'>"+comentario.getNome()+"</p>");
					out.println("<p style='font-size:16px;padding-left:30px;'>"+comentario.getTexto()+"</p>");
					out.println("</div>");
					out.println("<hr/>");
				}
				out.println("<div>");
			}
			out.println("<div>");
			out.println("<p style='font-size:24px;padding-left:25px;'>Adicionar Comentário</p>");
			out.println("<form style='font-size:24px;padding-left:30px;width : 50%;' action='adicionarcomentario.do' method='POST'>");
			out.println("Nome: <input style='width : 880px;height:35px;border-radius: 5px;border:1px solid #000' type='text' name='nome'>");
			out.println("<div style='display: flex;padding-top:20px;'><p style='margin-top: 0px;'>Comentário: </p><textarea style='margin-left:10px;border-radius: 5px;border:1px solid #000' name='comentario' cols='120' rows='6'></textarea> </div>");
			out.println("<button type='submit' style = 'float:right;height:40px;width:150px;font-size:20px;margin-top:10px;border-radius: 5px;border:1px solid #000'>Enviar</button>");
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
