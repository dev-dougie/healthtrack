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

import br.com.healthtrack.bean.Peso;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/peso")
public class PesoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PesoDAO dao;
	
	@Override
	public void init() throws ServletException{
		super.init();
		dao = DAOFactory.getPesoDAO();
	}
     
    @Override
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
		List<Peso> lista = dao.getAll();
		request.setAttribute("pesos", lista);
		request.getRequestDispatcher("lista-pesos.jsp").forward(request, response);
	}
	
	protected void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("codigo"));
		Peso peso = dao.getById(id);
		request.setAttribute("peso", peso);
		request.getRequestDispatcher("edicao-peso.jsp").forward(request, response);
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
			double valorPesagem = Double.parseDouble(request.getParameter("peso"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataPeso = Calendar.getInstance();
			dataPeso.setTime(format.parse(request.getParameter("data-peso")));
			
			Peso peso = new Peso(0, 1, valorPesagem, dataPeso);
			dao.create(peso);
			
			request.setAttribute("message", "Peso inserido com sucesso!");
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar Peso");
		}
			
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		request.getRequestDispatcher("cadastro-peso.jsp").forward(request, response);
	}
	
	private void editar	(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			double valorPesagem = Double.parseDouble(request.getParameter("peso"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataPeso = Calendar.getInstance();
			dataPeso.setTime(format.parse(request.getParameter("data-peso")));
			
			Peso peso = new Peso(codigo, 1, valorPesagem, dataPeso);
			
			dao.update(peso);
			
			request.setAttribute("message", "Peso atualizado com sucesso!");
			
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar Peso");
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
			dao.delete(codigo);
			request.setAttribute("msg", "Peso removido!");
		}catch (DBException e) {
				e.printStackTrace();
				request.setAttribute("erro", "Erro ao atualizar");
		}
			listar(request,response);
	}
}
