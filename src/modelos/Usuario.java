/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;


public class Usuario {

    private int id;
    private String email;
    private String contraseña;
    private int cc_trabajador;
    private Trabajador trabajador;

    public Usuario(String email, String contraseña, int cc_trabajador) {
        this.email = email;
        this.contraseña = contraseña;
        this.cc_trabajador = cc_trabajador;
    }

    
    public Usuario(int id, String email, String contraseña, int cc_trabajador) {
        this.id = id;
        this.email = email;
        this.contraseña = contraseña;
        this.cc_trabajador = cc_trabajador;
    }

    public Usuario(int id, String email, String contraseña, int cc_trabajador, Trabajador trabajador) {
        this.id = id;
        this.email = email;
        this.contraseña = contraseña;
        this.cc_trabajador = cc_trabajador;
        this.trabajador = trabajador;
    }
    
    public Object[] getDatos(){
     return new Object[]{id, email, cc_trabajador};
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getCc_trabajador() {
        return cc_trabajador;
    }

    public void setCc_trabajador(int cc_trabajador) {
        this.cc_trabajador = cc_trabajador;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    
    
    
}
