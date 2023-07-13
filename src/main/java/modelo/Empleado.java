package modelo;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleado")
public class Empleado implements Serializable {
	private static final long serialVersionUID= 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "empleado_id")
	private int empleadoid;
    private String cargo;
    
  //agregar relacion uno a uno
  	@OneToOne
  	@JoinColumn(name = "persona_id")
  	private Persona persona;
  	
  	@OneToMany
    @JoinColumn(name = "ticket_id")
    private Set<Ticket> ticket;
    
    

    public Empleado() {
	
	}
    
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Set<Ticket> getTicket() {
		return ticket;
	}

	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}

	public Empleado(int empleadoid, String cargo) {
        this.empleadoid = empleadoid;
        this.cargo = cargo;
    }

    public int getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(int empleadoid) {
        this.empleadoid = empleadoid;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

	@Override
	public String toString() {
		return "Empleado [empleadoid=" + empleadoid + ", cargo=" + cargo + ", persona=" + persona + ", ticket=" + ticket
				+ "]";
	}

   
    

}
