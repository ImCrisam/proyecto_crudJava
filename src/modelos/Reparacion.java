/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author David Raigosa
 */
public class Reparacion {

    
    private int id;
    private String descripcion;
    private double valor;
    private int id_maquina_mantenimiento;

    public Reparacion(int id, String descripcion, double valor) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public Reparacion(String descripcion, double valor, int id_maquina_mantenimiento) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.id_maquina_mantenimiento = id_maquina_mantenimiento;
    }

    
    
    public Reparacion(int id, String descripcion, double valor, int id_maquina_mantenimiento) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
        this.id_maquina_mantenimiento = id_maquina_mantenimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getId_maquina_mantenimiento() {
        return id_maquina_mantenimiento;
    }

    public void setId_maquina_mantenimiento(int id_maquina_mantenimiento) {
        this.id_maquina_mantenimiento = id_maquina_mantenimiento;
    }
    
    
    
}
