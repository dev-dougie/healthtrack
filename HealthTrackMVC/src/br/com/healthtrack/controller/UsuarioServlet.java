package br.com.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.bean.UsuarioLogin;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.dao.UsuarioLoginDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;


@WebServlet("/cadastro-usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private UsuarioDAO udao;
	private UsuarioLoginDAO uldao;
	
	@Override
    public void init() throws ServletException {
    	super.init();
    	udao = DAOFactory.getUsuarioDAO();
    	uldao = DAOFactory.getUsuarioLoginDAO();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome = request.getParameter("name");
			String cpf 	= request.getParameter("cpf");
			String username = request.getParameter("nickname");
			String email = request.getParameter("email");
			String senha = request.getParameter("password");
			String confirmPassword = request.getParameter("conf-password");
			checkPassword(senha, confirmPassword);
			String telefone = request.getParameter("telefone");
			String endereco = request.getParameter("address");
			
			double peso = Double.parseDouble(request.getParameter("weight"));
			double altura = Double.parseDouble(request.getParameter("height"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(format.parse(request.getParameter("data-nascimento")));
			String sexo = request.getParameter("gender");
			
			Usuario usuario = new Usuario(0, nome, cpf, email, dataNascimento, sexo, altura, peso, username, endereco, telefone, (altura/(peso*peso)), senha);
			
			udao.create(usuario);
			
			UsuarioLogin usuarioLogin = new UsuarioLogin(email, senha);
			
			uldao.create(usuarioLogin);
			
			
			request.setAttribute("msg", "Agora só basta fazer o Login com o e-mail e senha!");
			
		}catch(DBException db) {
			db.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		request.getRequestDispatcher("cadastro-usuario.jsp").forward(request, response);
	}

	private boolean checkPassword(String senha, String confirmPassword) {
		if(senha == confirmPassword) {
				return true;
		}return false;
		
	}

}
