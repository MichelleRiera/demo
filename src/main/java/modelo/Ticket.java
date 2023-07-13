package modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private int ticketid;
    //private double costoTarifa;
    
    private Date fecha,hora_entrada,hora_salida;
    //relacion empleado da muchos tickets
    @OneToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    //relacion tarifa 
    @OneToOne
    @JoinColumn(name = "tarifa_id")
    private Tarifa tarifa;
    
    
    

    public Ticket() {
		
	}

	public Ticket(int ticketid, Date fecha, Date hora_entrada, Date hora_salida) {
        this.ticketid = ticketid;
       // this.costoTarifa = costoTarifa;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
    }

   

   
    public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Date getFecha() {
        return fecha;
    }

  

    public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Date hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Date getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Date hora_salida) {
        this.hora_salida = hora_salida;
    }

	@Override
	public String toString() {
		return "Ticket [ticketid=" + ticketid + ", fecha=" + fecha + ", hora_entrada=" + hora_entrada + ", hora_salida="
				+ hora_salida + ", empleado=" + empleado + ", tarifa=" + tarifa + "]";
	}

	
    

    
    
}
