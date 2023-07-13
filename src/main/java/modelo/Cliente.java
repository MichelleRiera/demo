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
@Table(name = "Cliente")
public class Cliente implements Serializable{
	private static final long serialVersionUID= 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	 private int clienteid;
	//agregar relacion uno a uno
  	@OneToOne
  	@JoinColumn(name = "persona_id")
  	private Persona persona;
  	
  	 @OneToMany
	 @JoinColumn(name = "cliente_id")
	 private Set<Vehiculo> vehiculos;

    
    @OneToMany(mappedBy = "cliente")
	private Set<Factura> factura;
    
    
       
    public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}


	public void setVehiculos(Set<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}


	public Set<Factura> getFactura() {
		return factura;
	}


	public void setFactura(Set<Factura> factura) {
		this.factura = factura;
	}


		public Cliente() {
	
	   }
	    

		public Cliente(int clienteid) {
	        this.clienteid = clienteid;
	    }

	    public int getClienteid() {
	        return clienteid;
	    }

	    public void setClienteid(int clienteid) {
	        this.clienteid = clienteid;
	    }


		@Override
		public String toString() {
			return "Cliente [clienteid=" + clienteid + ", persona=" + persona + ", vehiculos=" + vehiculos
					+ ", factura=" + factura + "]";
		}

	   
	    

}
