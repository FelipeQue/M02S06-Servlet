package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Tutoria;

public class TutoriaRepository {

	private static List<Tutoria> tutorias = new ArrayList<>();
	private static int ultimoIdTutoria;
	
	public List<Tutoria> listarTutorias() {
	    return tutorias;
	  }

	  public void adicionarTutoria(Tutoria tutoria) {
		tutoria.setId(++ultimoIdTutoria);
	    tutorias.add(tutoria);
	  }

	  public void removerTutoria(Tutoria tutoria) {
		  tutorias.remove(tutoria);
	  }
	  
	  public Tutoria buscar(int id) {
		    return tutorias.stream().filter(tutoria -> id == tutoria.getId()).findFirst().orElse(null);
		  }
	
}
