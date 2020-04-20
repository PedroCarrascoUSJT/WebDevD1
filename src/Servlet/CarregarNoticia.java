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
		int id = Integer.parseInt(request.getParameter("id"));
		Noticia noticia = new NoticiaService().carregaNoticia(id);
		if(noticia.getId() == -1) {
			response.setStatus(500);
			response.getWriter().append("<p> Noticia não encontrada! </p>")
								.append("<img src = 'https://http.cat/404'>");
			return;
		}
		
		response.getWriter().append("<p style='font-size : 64px;font-weight : bold;'>Real News</p>")
						.append("<p style='font-size : 64px;font-weight : bold;text-align : center'>"+noticia.getTitulo()+"</p>")
						.append("<p style='font-size :32px;text-align : center'>"+noticia.getTexto()+"</p>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
