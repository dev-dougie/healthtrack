package br.com.healthtrack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Contato;
import br.com.healthtrack.dao.ContatoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/contato")
public class ContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ContatoServlet() {
        super();
    }
    
    private ContatoDAO contato;
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	contato = DAOFactory.getContato();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String mensagem = request.getParameter("mensagem");
			
			Contato ctt = new Contato(0, nome, email, mensagem);
			contato.create(ctt);
			
			request.setAttribute("msg", "Mesagem enviada! Em breve retornaremos");
		}
		catch(DBException d) {
			d.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		
		request.getRequestDispatcher("contato.jsp").forward(request, response);
	}

}
