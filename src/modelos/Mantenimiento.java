/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.util.ArrayList;
import modelos.Maquinas_Mantenimiento;

/**
 *
 * @author David Raigosa
 */
public class Mantenimiento {
    
    private int id;
    private String fecha;
    private double valor;
    private int cc_cliente;
    private Cliente cliente;
    private ArrayList<Maquinas_Mantenimiento> array;

    public Mantenimiento(int id, String fecha, double valor, int cc_cliente) {
        this.id = id;
        this.fecha = fecha;
        this.valor = valor;
        this.cc_cliente = cc_cliente;
        this.array = new ArrayList<>();
    }

    public Mantenimiento(int id, String fecha, double valor, int cc_cliente, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.valor = valor;
        this.cc_cliente = cc_cliente;
        this.cliente = cliente;
         this.array = new ArrayList<>();
    }

    public Mantenimiento(String fecha, double valor, int cc_cliente) {
        this.fecha = fecha;
        this.valor = valor;
        this.cc_cliente = cc_cliente;
         this.array = new ArrayList<>();
    }
    public Object[] getDatos(){
     return new Object[]{id, fecha, valor, cc_cliente};
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCc_cliente() {
        return cc_cliente;
    }

    public void setCc_cliente(int cc_cliente) {
        this.cc_cliente = cc_cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Maquinas_Mantenimiento> getArray() {
        return array;
    }

    public void setArray(ArrayList<Maquinas_Mantenimiento> array) {
        this.array = array;
    }
    
    
    
    
    
    
}
