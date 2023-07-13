package negocio;

import java.util.List;

import Dao.PersonaDao;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import modelo.Persona;

@Stateless
public class gestionClientes {
	@Inject
	private PersonaDao daoPersona;
	
	public void guardarClientes(Persona persona) throws Exception {
	    if (!this.isCedulaValida(persona.getCedula())) {
	        throw new Exception("Cedula incorrecta");
	    }

	    Persona personaExistente = daoPersona.getByCedula(persona.getCedula());

	    if (personaExistente == null) {
	        try {
	            daoPersona.insert(persona);
	        } catch (Exception e) {
	            throw new Exception("Error al insertar: " + e.getMessage());
	        }
	    } else {
	        try {
	            persona.setPersonaid(personaExistente.getPersonaid());  // Asegura que el ID de la persona existente se mantenga
	            daoPersona.update(persona);
	        } catch (Exception e) {
	            throw new Exception("Error al actualizar: " + e.getMessage());
	        }
	    }
	}



	    private boolean isCedulaValida(String cedula) {
	        return cedula.length() == 10;
	    }
	    
	    public List<Persona> listarPersonas() {
	        return daoPersona.getAll();
	    }
	}