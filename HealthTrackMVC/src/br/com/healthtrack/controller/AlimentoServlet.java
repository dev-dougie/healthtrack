package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Alimento;
import br.com.healthtrack.dao.AlimentoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/alimento")
public class AlimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private AlimentoDAO dao;
	
	@Override
	public void init() throws ServletException{
		super.init();
		dao = DAOFactory.getAlimentoDAO();
	}
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
			String acao = request.getParameter("acao");
			switch(acao){
			case "listar":
				listar(request, response);	
				break;
			case "abrir-form-edicao":
				abrirFormEdicao(request, response);
				break;
			}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Alimento> lista = dao.getAll();
		request.setAttribute("alimentos", lista);
		request.getRequestDispatcher("lista-alimentos.jsp").forward(request, response);
	}
	
	protected void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("codigo"));
		Alimento alimento = dao.getById(id);
		request.setAttribute("alimento", alimento);
		request.getRequestDispatcher("edicao-alimento.jsp").forward(request, response);
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
			String nome = request.getParameter("nome");
			double calorias = Double.parseDouble(request.getParameter("calorias"));
			String infoNutricionais = request.getParameter("infos-nutricionais");
			String descricao = request.getParameter("descricao");
			
			Alimento alimento = new Alimento(0, nome, calorias, infoNutricionais, descricao);
			dao.create(alimento);
			
			request.setAttribute("message", "Alimento inserido com sucesso!");
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar Alimento");
		}
			
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		request.getRequestDispatcher("cadastro-alimento.jsp").forward(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("nome");
			double calorias = Double.parseDouble(request.getParameter("calorias"));
			String infoNutricionais = request.getParameter("infos-nutricionais");
			String descricao = request.getParameter("descricao");
			
			Alimento alimento = new Alimento(codigo, nome, calorias, infoNutricionais, descricao);
			dao.update(alimento);
			
			request.setAttribute("message", "Alimento atualizado com sucesso!");
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar Alimento");
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
				request.setAttribute("msg", "Alimento removido!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}
		listar(request,response);
	}

}


