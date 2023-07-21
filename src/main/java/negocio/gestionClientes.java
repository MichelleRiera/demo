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
		if(!this.isCedulaValida(persona.getCedula()))
			throw new Exception("Cedula incorrecta");
		
		if(daoPersona.read(persona.getPersonaid()) == null) {
			try {
				daoPersona.insert(persona);
			}catch(Exception e) {
				throw new Exception("Error al insertar: " + e.getMessage());
			}
		}else {
			try {
				daoPersona.update(persona);
			}catch(Exception e) {
				throw new Exception("Error al actualizar: " + e.getMessage());
			}
		}
	}

    public void guardarClientes(String cedula, String nombre, String apellido, String direccion, String telefono) {
        // Implementa la lógica para guardar un cliente utilizando los parámetros proporcionados
    }

    private boolean isCedulaValida(String cedula) {
        return cedula.length() == 10;
    }

    public List<Persona> listarPersonas() {
        return daoPersona.getAll();
    }
    
    public void delete(String cedula) {
        daoPersona.delete(cedula);
    }
}
