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
public class Maquina {
    
    private int id;
    private String serie;
    private String modelo;
    private String marca;
    private String nombre;
    private String tipo;

    public Maquina(String serie, String modelo, String marca, String nombre, String tipo) {
        this.serie = serie;
        this.modelo = modelo;
        this.marca = marca;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public Maquina(int id, String seial, String modelo, String marca, String nombre, String tipo) {
        this.id = id;
        this.serie = seial;
        this.modelo = modelo;
        this.marca = marca;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    public Object[] getDatos(){
     return new Object[]{id, serie, modelo, marca, nombre, tipo};
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
