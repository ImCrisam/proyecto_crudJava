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
public class Factura {
    
    private int id;
    private int id_mantenimiento;

    public Factura(int id) {
        this.id = id;
    }

    public Factura(int id, int id_mantenimiento) {
        this.id = id;
        this.id_mantenimiento = id_mantenimiento;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_mantenimiento() {
        return id_mantenimiento;
    }

    public void setId_mantenimiento(int id_mantenimiento) {
        this.id_mantenimiento = id_mantenimiento;
    }
    
    
}
