package servicios;




import java.util.ArrayList;
import java.util.List;

import Dao.PersonaDao;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import modelo.Persona;
import negocio.gestionClientes;

@Path("Clientes")
public class GClientesService {
	
	@Inject 
	private PersonaDao daoPersona;
	
	@Inject
	private gestionClientes clientes;
	
	private List<Persona> personas = new ArrayList<>();
	

    /*public GClientesService() {
        // Ingresar las 3 personas directamente en el constructor
        Persona persona1 = new Persona();
        persona1.setCedula("01111111111");
        persona1.setNombre("Michelle");
        persona1.setApellido("parraga");
        persona1.setTelefono( "1245487542");
        persona1.setDireccion("Monay");
        personas.add(persona1);

        Persona persona2 = new Persona();
        persona2.setCedula("02222222222");
        persona2.setNombre("Juan");
        persona2.setApellido("Riera");
        persona2.setTelefono( "1111111111");
        persona2.setDireccion("Paqrque miraflores");
        personas.add(persona2);

        Persona persona3 = new Persona();
        persona3.setCedula("03333333333");
        persona3.setNombre("María");
        persona3.setApellido("Miranda");
        persona3.setTelefono( "888888888");
        persona3.setDireccion("Milenium");
        personas.add(persona3);
    }*/
    
	@GET
	@Path("saludp")
	public String saludo() {
		return"Hola mundo";
	}
	
	@GET
	@Path("suma")
	public String suma(@QueryParam("a")int a,
			@QueryParam("b") int b) {
		return "R ="+(a+b);
	}
	
	@GET
	@Path("multiplicacion/{a}/{b}")
	public String multiplicacion(@PathParam("a")int a,
			@PathParam("b") int b) {
		return "R ="+(a * b);
	}
	
	
	@GET
	@Path("misdatos")
	@Produces("application/json")
	public Persona misDatos() {
		Persona p = new Persona();
		p.setCedula("01111111111");
		p.setNombre("Michelle");
		
		return p;
	}
	
	@GET
	@Path("ingresar")
	@Produces("application/json")
	public String ingresarPersona(@QueryParam("cedula") String cedula, @QueryParam("nombre") String nombre) {
		Persona persona = new Persona();
		persona.setCedula(cedula);
		persona.setNombre(nombre);
		personas.add(persona);
		
		return "Persona ingresada correctamente.";
	}
	
	/*@GET
	@Path("listar")
	@Produces("application/json")
	public List<Persona> listarPersonas() {
		return personas;
	}
	
	@GET
    @Path("listar2")
    @Produces("application/json")
    public List<Persona> listarPersonas2() {
        return daoPersona.getAll();
    }*/
	
	    @GET
	    @Path("listarPersonas")
	    @Produces("application/json")
	    public List<Persona> listarPersonas() {
	        return clientes.listarPersonas();
	    }

	    @POST
	    @Path("registrar")
	    @Produces("application/json")
	    public Response guardarCliente(Persona persona) {
	        try {
	            clientes.guardarClientes(persona);
	            return Response.status(Response.Status.OK).entity(persona).build();
	        } catch (Exception e) {
	            e.printStackTrace();
	            Error error = new Error();
	            error.setCodigo(99);
	            error.setMensaje("Error al guardar: " + e.getMessage());
	            return Response.status(Response.Status.OK).entity(error).build();
	        }
	    }
	}
	

