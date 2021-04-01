/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;
import java.util.ArrayList;
import modelos.Reparacion;
/**
 *
 * @author David Raigosa
 */
public class Maquinas_Mantenimiento {
    
    private int id;
    private int id_mantenimiento;
    private int id_maquina;
    private int cc_trabajador;
    private Trabajador trabajador;
    private Maquina maquina;
    private ArrayList<Reparacion> array;

    public Maquinas_Mantenimiento(int id_mantenimiento, int id_maquina, int cc_trabajador) {
        this.id_mantenimiento = id_mantenimiento;
        this.id_maquina = id_maquina;
        this.cc_trabajador = cc_trabajador;
         this.array = new ArrayList<>();
    }

    public Maquinas_Mantenimiento(int id, int id_mantenimiento, int id_maquina, int cc_trabajador) {
        this.id = id;
        this.id_mantenimiento = id_mantenimiento;
        this.id_maquina = id_maquina;
        this.cc_trabajador = cc_trabajador;
         this.array = new ArrayList<>();
    }

    public Maquinas_Mantenimiento(int id, int id_mantenimiento, int id_maquina, int cc_trabajador, Trabajador trabajador, Maquina maquina) {
        this.id = id;
        this.id_mantenimiento = id_mantenimiento;
        this.id_maquina = id_maquina;
        this.cc_trabajador = cc_trabajador;
        this.trabajador = trabajador;
        this.maquina = maquina;
         this.array = new ArrayList<>();
    }
    
    public Object[] getDatos(){
     return new Object[]{id, id_maquina, cc_trabajador};
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

    public int getId_maquina() {
        return id_maquina;
    }

    public void setId_maquina(int id_maquina) {
        this.id_maquina = id_maquina;
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

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public ArrayList<Reparacion> getArray() {
        return array;
    }

    public void setArray(ArrayList<Reparacion> array) {
        this.array = array;
    }
    
    
    
}
