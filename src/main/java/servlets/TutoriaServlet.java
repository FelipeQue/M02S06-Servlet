package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import entities.Tutoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.TutoriaRepository;

@WebServlet(value = "/tutoria")
public class TutoriaServlet extends HttpServlet {
	
	private final TutoriaRepository tutoriaRepository = new TutoriaRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		var tutorias = tutoriaRepository.listarTutorias();
		
		if (tutorias.isEmpty()) {
				writer.print("Não existem tutores/as cadastrades.");
		    } else {
		    	for (Tutoria tutoria : tutorias) {
		    		writer.print("Id: " + tutoria.getId() + ". " +
		    				"Nome: " + tutoria.getNome() + ". " +
		    				"Espécie: " + tutoria.getTelefone() + ". " +
		    				"Raça: " + tutoria.getEndereco() + ". " +
		    				"Sexo: " + tutoria.getEmail() + ". " +
		    				"Pets: " + tutoria.getPets() + ". |"
		    				);	
		    	}	
		    }
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		Tutoria novaTutoria = new Tutoria();
		novaTutoria.setNome(req.getParameter("nome"));
		novaTutoria.setTelefone(req.getParameter("telefone"));
		novaTutoria.setEndereco(req.getParameter("endereço"));
		novaTutoria.setEmail(req.getParameter("e-mail"));
		tutoriaRepository.adicionarTutoria(novaTutoria);
		
		writer.print("Tutor/a/e adicionade com sucesso: " + novaTutoria);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		var tutoriaAtualizar = tutoriaRepository.buscar(Integer.parseInt(req.getParameter("id")));
	    if (tutoriaAtualizar != null) {
	    	tutoriaAtualizar.setNome(req.getParameter("nome"));
	    	tutoriaAtualizar.setTelefone(req.getParameter("telefone"));
	    	tutoriaAtualizar.setEndereco(req.getParameter("endereço"));
	    	tutoriaAtualizar.setEmail(req.getParameter("e-mail"));
	    	writer.print("Informações de tutoria atualizadas. " + tutoriaAtualizar);
	    } else {
	    	writer.print("Tutoria não encontrada.");
	    }
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		var tutoriaRemovente = tutoriaRepository.buscar(Integer.parseInt(req.getParameter("id")));
		if (tutoriaRemovente != null) {
		      tutoriaRepository.removerTutoria(tutoriaRemovente);
		      writer.print("Tutoria removida com sucesso.");
		    } else { 
			writer.print("Tutoria não encontrada.");
		    }
		
		
	}

}
