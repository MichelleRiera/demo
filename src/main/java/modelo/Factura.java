package modelo;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Factura")
public class Factura implements Serializable{
	    private static final long serialVersionUID= 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "factura_id")
		private int facturaId;
	    private Date fecha;
	 
	    
	  //relacion muchos
	    @OneToOne
	    @JoinColumn(name = "cliente_id")
	    private Cliente cliente;
	    
	    @OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name="fac_codigo")
		private List<FacturaDetalle> detalles;
	    
	    
        
	    public Factura() {
			
		}

		public Factura(int facturaId, Date fecha, double subtotal, double iva, double total) {
	        this.facturaId = facturaId;
	        this.fecha = fecha;
	        
	    }
        
	    public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public List<FacturaDetalle> getDetalles() {
			return detalles;
		}

		public void setDetalles(List<FacturaDetalle> detalles) {
			this.detalles = detalles;
		}

		public int getFacturaId() {
	        return facturaId;
	    }

	    public void setFacturaId(int facturaId) {
	        this.facturaId = facturaId;
	    }

	    public Date getFecha() {
	        return fecha;
	    }

	    public void setFecha(Date fecha) {
	        this.fecha = fecha;
	    }
	    
	    public void addDetalle(FacturaDetalle detalle) {
			if(detalles == null) {
				detalles = new ArrayList<FacturaDetalle>();
			}
			detalles.add(detalle);
			
		}

		@Override
		public String toString() {
			return "Factura [facturaId=" + facturaId + ", fecha=" + fecha + ", cliente=" + cliente + ", detalles="
					+ detalles + "]";
		}

		
	    

	  

}
