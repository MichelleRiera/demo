package negocio;


import Dao.ClienteDao;
import Dao.DetalleDato;
import Dao.EmpleadoDao;
import Dao.FacturaDao;
import Dao.PersonaDao;
import Dao.TarifaDao;
import Dao.TicketDao;
import Dao.VehiculoDao;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Factura;
import modelo.FacturaDetalle;
import modelo.Persona;
import modelo.Tarifa;
import modelo.Ticket;
import modelo.Vehiculo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



@Singleton
@Startup
public class DatosDemo {
	@Inject 
	private PersonaDao daoPersona;
	
	@Inject
	private TarifaDao tarifaDao;
	
	@Inject
	private ClienteDao clienteDao;
	
	@Inject
	private VehiculoDao vehiculoDao;
	
	@Inject
	private EmpleadoDao empleadoDao;
	
	@Inject
	private TicketDao ticketDao;
	
	@Inject
	private FacturaDao facturaDao;
	
	@Inject
	private DetalleDato detalleDato;
	
	
	@PostConstruct
	public void init() {
		System.out.println("Hola UPS");
		
		Persona p = new Persona();
		p.setCedula("0103709911");
		p.setNombre("michelle");
		p.setApellido("parraga");
		p.setTelefono( "1245487542");
		p.setDireccion("Monay");
		
		Persona p1 = new Persona();
		p1.setCedula("1111111111");
		p1.setNombre("karla");
		p1.setApellido("Riera");
		p1.setTelefono( "1111111111");
		p1.setDireccion("Paqrque miraflores");
		
		Persona p2 = new Persona();
		p2.setCedula("2222222222");
		p2.setNombre("Evelyn");
		p2.setApellido("Miranda");
		p2.setTelefono( "888888888");
		p2.setDireccion("Milenium");
		
		daoPersona.insert(p);
		daoPersona.insert(p1);
		daoPersona.insert(p2);
		
		Cliente c1= new Cliente();
		c1.setPersona(p);
		clienteDao.insert(c1);
		
		Vehiculo v1= new Vehiculo();
		v1.setPlaca("avsc-1212");
		v1.setCliente(c1);
		vehiculoDao.insert(v1);
		
		Tarifa t1= new Tarifa();
		t1.setCostoTarifa(2);
		t1.setTipoVehiculo("Camion");
		
		tarifaDao.insert(t1);
		
		Empleado e1= new Empleado();
		e1.setCargo("General");
		e1.setPersona(p2);
		
		empleadoDao.insert(e1);
		
		Ticket tc1= new Ticket();
		tc1.setFecha(new Date(0));
		tc1.setHora_entrada(new Date(0));
		tc1.setHora_salida(new Date(0));
		tc1.setTarifa(t1);
		tc1.setEmpleado(e1);
		
		ticketDao.insert(tc1);
		
		
		
		
		Factura f= new Factura();
		f.setFecha(new Date(0));
		f.setCliente(c1);
		
		facturaDao.insert(f);
		
		FacturaDetalle fd= new FacturaDetalle();
		fd.setSubtotal(2);
		fd.setIVA(0.12);
		fd.setTotal(2.24);
		fd.setTicket(tc1);
		detalleDato.insert(fd);
		
		//f.addDetalle(fd);
		
		List<Persona> persona = daoPersona.getAll();
		for(Persona per: persona) {
			System.out.println(per);
		}
	}
}
