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
public class Cliente {
    
    private int cc;
    private String nombre;
    private String apellido;
    private String celular;
    private String tipo;

    public Cliente(int cc, String nombre, String apellido, String celular, String tipo) {
        this.cc = cc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.tipo = tipo;
    }
    
    public Object[] getDatos(){
     return new Object[]{cc, nombre, apellido, celular,tipo};
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
