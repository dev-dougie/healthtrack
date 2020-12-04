package br.com.healthtrack.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrack.bean.UsuarioLogin;

import br.com.healthtrack.dao.UsuarioLoginDAO;

import br.com.healthtrack.factory.DAOFactory;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioLoginDAO uldao;

	
	
	public LoginServlet() {
        uldao = DAOFactory.getUsuarioLoginDAO();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		
		UsuarioLogin usuarioLogin = new UsuarioLogin(email, senha);
		
		if (uldao.validarUsuario(usuarioLogin)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", email);
		
		}else {
			request.setAttribute("erro", "Email e/ou senha inválidos");
		}
		request.getRequestDispatcher("cadastro-alimento.jsp").forward(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}