package br.com.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Pressao;
import br.com.healthtrack.dao.PressaoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/pressao")
public class PressaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private PressaoDAO pdao;
	
	@Override
	public void init() throws ServletException{
		super.init();
		pdao = DAOFactory.getPressaoDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "listar":
			listar(request, response);
		break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
		break;
		}
			
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pressao> lista = pdao.getAll();
		request.setAttribute("pressoes", lista);
		request.getRequestDispatcher("lista-pressoes.jsp").forward(request, response);
	}
	
	protected void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("codigo"));
		Pressao pressao = pdao.getById(id);
		request.setAttribute("pressao", pressao);
		request.getRequestDispatcher("edicao-pressao.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "cadastrar":
			cadastrar(request, response);
		break;
		case "editar":
			editar(request, response);
		break;
		case "exclur":
			excluir(request, response);
		break;
		}
		
		
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int sistolica = Integer.parseInt(request.getParameter("pres-sistolica"));
			int diastolica = Integer.parseInt(request.getParameter("pres-diastolica"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataAfericao = Calendar.getInstance();
			dataAfericao.setTime(format.parse(request.getParameter("data-afericao")));
			
			Pressao pressao = new Pressao(0, 1, sistolica, diastolica, dataAfericao);
			pdao.create(pressao);
			
			request.setAttribute("message", "Pressão inserida com sucesso!");
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar Pressão");
		}
			
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		request.getRequestDispatcher("cadastro-pressao.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			int sistolica = Integer.parseInt(request.getParameter("pres-sistolica"));
			int diastolica = Integer.parseInt(request.getParameter("pres-diastolica"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataAfericao = Calendar.getInstance();
			dataAfericao.setTime(format.parse(request.getParameter("data-afericao")));
			
			Pressao pressao = new Pressao(codigo, 1, sistolica, diastolica, dataAfericao);
			pdao.update(pressao);
			
			request.setAttribute("message", "Pressão atualizada com sucesso!");
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar Pressão");
		}
			
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		
		listar(request, response);
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		try {
			pdao.delete(codigo);
			request.setAttribute("msg", "Pressão removida!");
	} catch (DBException e) {
		e.printStackTrace();
		request.setAttribute("erro", "Erro ao atualizar");
	}
	listar(request,response);
	}
	
}
