package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import entities.Pet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repositories.PetRepository;

@WebServlet(value = "/pet")
public class PetServlet extends HttpServlet {
	
	private final PetRepository petRepository = new PetRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		var pets = petRepository.listarPets();
		
		if (pets.isEmpty()) {
				writer.print("Não existem pets cadastrados.");
		    } else {
		    	for (Pet pet : pets) {
		    		writer.print("Id: " + pet.getId() + ". " +
		    				"Nome: " + pet.getNome() + ". " +
		    				"Espécie: " + pet.getEspecie() + ". " +
		    				"Raça: " + pet.getRaca() + ". " +
		    				"Sexo: " + pet.getSexo() + ". " +
		    				"Data de nascimento: " + pet.getDataNascimento() + ". " +
		    				"Peso: " + pet.getPeso() + ". |"
		    				);	
		    	}	
		    	
		    }
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		Pet novoPet = new Pet();
		novoPet.setNome(req.getParameter("nome"));
		novoPet.setEspecie(req.getParameter("espécie"));
		novoPet.setRaca(req.getParameter("raça"));
		novoPet.setSexo(req.getParameter("sexo"));
		novoPet.setDataNascimento(req.getParameter("data de nascimento"));
		novoPet.setPeso(Double.parseDouble(req.getParameter("peso")));
		petRepository.adicionarPet(novoPet);
		
		writer.print("Pet adicionado com sucesso: " + novoPet);
		
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		var petAtualizar = petRepository.buscar(Integer.parseInt(req.getParameter("id")));
		    if (petAtualizar != null) {
		    	petAtualizar.setNome(req.getParameter("nome"));
		    	petAtualizar.setEspecie(req.getParameter("espécie"));
		    	petAtualizar.setRaca(req.getParameter("raça"));
		    	petAtualizar.setSexo(req.getParameter("sexo"));
		    	petAtualizar.setDataNascimento(req.getParameter("data de nascimento"));
		    	petAtualizar.setPeso(Double.parseDouble(req.getParameter("peso")));
		    	writer.print("Informações de pet atualizadas. " + petAtualizar);
		    } else {
		    	writer.print("Pet não encontrado.");
		    }
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		
		var petRemovente = petRepository.buscar(Integer.parseInt(req.getParameter("id")));
		if (petRemovente != null) {
		      petRepository.removerPet(petRemovente);
		      writer.print("Pet removido com sucesso.");
		    } else { 
			writer.print("Pet não encontrado.");
		    }
		
		
		
		
	}
	
}
