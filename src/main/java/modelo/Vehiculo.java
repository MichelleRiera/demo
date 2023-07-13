package modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "Vehiculos")
public class Vehiculo implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "vehiculo_id")
	private int vehiculoId;
    private String placa;
    
    //relacion cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    

    public Vehiculo() {
		
	}
    
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vehiculo(int vehiculoId, String placa) {
        this.vehiculoId = vehiculoId;
        this.placa = placa;
    }

    public int getVehiculoId() {
        return vehiculoId;
    }

    public void setVehiculoId(int vehiculoId) {
        this.vehiculoId = vehiculoId;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

	@Override
	public String toString() {
		return "Vehiculo [vehiculoId=" + vehiculoId + ", placa=" + placa + ", cliente=" + cliente + "]";
	}

    
    
}



