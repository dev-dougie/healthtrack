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

import br.com.healthtrack.bean.Exercicio;
import br.com.healthtrack.bean.Treino;
import br.com.healthtrack.dao.ExercicioDAO;
import br.com.healthtrack.dao.TreinoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/treino")
public class TreinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	//Instanciando TreinoDAO
	private TreinoDAO dao;
	private ExercicioDAO edao;
    
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getTreinoDAO();
		edao = DAOFactory.getExercicioDAO();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		
		//Preciso informar direto na URL, com os parâemtros /treino?acao=listar
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
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Treino> lista = dao.getAll();
		request.setAttribute("treinos", lista);
		request.getRequestDispatcher("lista-treinos.jsp").forward(request, response);
	}
	
	protected void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("codigo"));
		Treino treino = dao.getById(id);
		request.setAttribute("treino", treino);
		carregarOpcoesExercicio(request);
		request.getRequestDispatcher("edicao-treino.jsp").forward(request, response);;
	}
	
	protected void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		carregarOpcoesExercicio(request);
		request.getRequestDispatcher("cadastro-treino.jsp").forward(request, response);
	}
		
	private void carregarOpcoesExercicio(HttpServletRequest request) {
		List<Exercicio> lista = edao.getAll();
		request.setAttribute("exercicios", lista);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao =  request.getParameter("acao");
		
		switch(acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			atualizar(request, response);
			break;
		case "exlcuir":
			excluir(request, response);
			break;
		}	
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//Capturando os atributos para cadastro
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataTreino = Calendar.getInstance();
			dataTreino.setTime(format.parse(request.getParameter("data-treino")));
			int duracaoMin = Integer.parseInt(request.getParameter("duracao-treino"));
			int freqCardiaca = Integer.parseInt(request.getParameter("freq-cardiaca"));
			double kcalQueimadas = Double.parseDouble(request.getParameter("calorias-queimadas"));
			String obs = request.getParameter("observacao");
			String descricao = request.getParameter("descricao");
			int exercicioRealizado = Integer.parseInt(request.getParameter("tipo-exercicio"));
			
			Exercicio exercicio = new Exercicio();
			exercicio.setId(exercicioRealizado);
			
			Treino treino = new Treino();
			treino.setIdTreino(0);
			treino.setExercicioRealizado(exercicio);
			treino.setIdUsuario(1);
			treino.setDescricao(descricao);
			treino.setDuracaoMin(duracaoMin);
			treino.setFreqCardiaca(freqCardiaca);
			treino.setKcalQueimadas(kcalQueimadas);
			treino.setObs(obs);
			treino.setDataTreino(dataTreino);
			
			dao.create(treino);
			
			request.setAttribute("msg", "Treino cadastrado com sucesso!");
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar Treino");
		}
			
		catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, valide os dados!");
		}
		
		request.getRequestDispatcher("cadastro-treino.jsp").forward(request, response);
	}
	
	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			int exercicioRealizado = Integer.parseInt("tipo-treino");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataTreino = Calendar.getInstance();
			dataTreino.setTime(format.parse(request.getParameter("data-treino")));
			int duracaoMin = Integer.parseInt(request.getParameter("duracao-treino"));
			int freqCardiaca = Integer.parseInt(request.getParameter("freq-cardiaca"));
			double kcalQueimadas = Double.parseDouble(request.getParameter("calorias-queimadas"));
			String obs = request.getParameter("observacao");
			String descricao = request.getParameter("descricao");
			
			Exercicio exercicio = new Exercicio();
			exercicio.setId(exercicioRealizado);
			
			Treino treino = new Treino();
			treino.setIdTreino(codigo);
			treino.setExercicioRealizado(exercicio);
			treino.setIdUsuario(1);
			treino.setDescricao(descricao);
			treino.setDuracaoMin(duracaoMin);
			treino.setFreqCardiaca(freqCardiaca);
			treino.setKcalQueimadas(kcalQueimadas);
			treino.setObs(obs);
			treino.setDataTreino(dataTreino);
			
			dao.update(treino);
			
		}catch(DBException d) {
			d.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar Treino");
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
				request.setAttribute("msg", "Treino removido!");
			} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
			}
			listar(request,response);
	}
}
