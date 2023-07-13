package modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FacturaDetalle")
public class FacturaDetalle implements Serializable {
	private static final long serialVersionUID= 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "detalle_id")
	private int detalleId;
	private double subtotal;
	private double IVA;
	private double total;
	
	
	//relacion con factura detalle
    @OneToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
	
	
	public FacturaDetalle() {
		
	}
	
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public int getDetalleId() {
		return detalleId;
	}
	public void setDetalleId(int detalleId) {
		this.detalleId = detalleId;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getIVA() {
		return IVA;
	}
	public void setIVA(double iVA) {
		IVA = iVA;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "FacturaDetalle [detalleId=" + detalleId + ", subtotal=" + subtotal + ", IVA=" + IVA + ", total=" + total
				+ ", ticket=" + ticket + "]";
	}
	
	
	
	

}
