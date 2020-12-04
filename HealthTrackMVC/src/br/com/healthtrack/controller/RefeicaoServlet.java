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

import br.com.healthtrack.bean.Alimento;
import br.com.healthtrack.bean.Refeicao;
import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.dao.AlimentoDAO;
import br.com.healthtrack.dao.RefeicaoDAO;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/refeicao")
public class RefeicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RefeicaoDAO rdao;
	private AlimentoDAO aDAO;
	private UsuarioDAO udao;
	

	@Override
	public void init() throws ServletException {
		super.init();
		rdao = DAOFactory.getRefeicaoDAO();
		aDAO = DAOFactory.getAlimentoDAO();
		udao = DAOFactory.getUsuarioDAO();
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
			case "abrir-form-cadastro":
				abrirFormCadastro(request, response);
			break;
		}		
	}
	
	protected void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Refeicao> lista = rdao.getAll();
			request.setAttribute("refeicoes", lista);
			request.getRequestDispatcher("lista-refeicoes.jsp").forward(request, response);
	}
	
	protected void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int id = Integer.parseInt(request.getParameter("codigo"));
		Refeicao refeicao = rdao.getById(id);
		request.setAttribute("refeicao", refeicao);
		carregarOpcoesAlimento(request);
		request.getRequestDispatcher("edicao-refeicao.jsp").forward(request, response);
	}
	
	protected void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		carregarOpcoesAlimento(request);
		request.getRequestDispatcher("cadastro-refeicao.jsp").forward(request, response);	
	
	}
	
	protected void carregarOpcoesAlimento(HttpServletRequest request){
	List<Alimento> lista = aDAO.getAll();
	request.setAttribute("alimentos", lista);
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
		 	case "excluir":
		 		excluir(request, response);
		 		break;
		 	}
	}
	
	protected void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//Capturando os atributos para cadastro
			int alimentoIngerido = Integer.parseInt(request.getParameter("food"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataRefeicao = Calendar.getInstance();
			dataRefeicao.setTime(format.parse(request.getParameter("meal-date")));
			String descricao = request.getParameter("meal-description");
			
			Alimento alimento = new Alimento();
			alimento.setIdAlimento(alimentoIngerido);
			
			Usuario usuario = udao.getById(1);
			
			Refeicao refeicao = new Refeicao();
			refeicao.setId_refeicao(0);
			
			refeicao.setAlimento(alimento);
			refeicao.setMomento_refeicao(dataRefeicao);
			refeicao.setDescricao(descricao);
			refeicao.setIdUsuario(usuario);
			
			
			rdao.create(refeicao);
			request.setAttribute("msg", "Refeição cadastrada com sucesso!");
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar Refeição");
		}
			
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		
		request.getRequestDispatcher("cadastro-refeicao.jsp").forward(request, response);
	}
		
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			int alimentoIngerido = Integer.parseInt(request.getParameter("food"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataRefeicao = Calendar.getInstance();
			dataRefeicao.setTime(format.parse(request.getParameter("meal-date")));
			String descricao = request.getParameter("meal-description");
			
			Alimento alimento = new Alimento();
			alimento.setIdAlimento(alimentoIngerido);
			
			Usuario usuario = udao.getById(1);
			
			Refeicao refeicao = new Refeicao();
			refeicao.setId_refeicao(codigo);
			refeicao.setAlimento(alimento);
			refeicao.setMomento_refeicao(dataRefeicao);
			refeicao.setDescricao(descricao);
			refeicao.setIdUsuario(usuario);
			
			rdao.update(refeicao);
			request.setAttribute("msg", "Refeição atualizada com sucesso!");
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar Refeição");
		}
			
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		listar(request, response);
	}
	
	protected void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		try {
			rdao.delete(codigo);
			request.setAttribute("msg", "Refeição removida!");
	} catch (DBException e) {
		e.printStackTrace();
		request.setAttribute("erro", "Erro ao atualizar");
	}
	listar(request,response);
	}
}
