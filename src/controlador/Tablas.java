/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author David Raigosa
 */
public class Tablas {

    private Conexion conexion;

    public Tablas() {
        this.conexion = new Conexion();
    }

    public void borraTablas() {
          String s="";
        
        s = "DROP TABLE factura ";
        conexion.crearTabla(s);
        
        s = "DROP TABLE reparaciones ";
        conexion.crearTabla(s);
        
        s = "DROP TABLE maquinas_mantenimiento ";
        conexion.crearTabla(s);
        
         s = "DROP TABLE mantenimientos ";
        conexion.crearTabla(s);
        
            s = "DROP TABLE clientes ";
        conexion.crearTabla(s);
        
            s = "DROP TABLE maquinas ";
        conexion.crearTabla(s);
        
            s = "DROP TABLE usuarios ";
        conexion.crearTabla(s);
        
            s = "DROP TABLE trabajadores ";
        conexion.crearTabla(s);
    }

    public void crearTablas() {
        int result = 0;
        //---tb clientes
        result = clientes();
        if (result == 1) {
            System.out.println("Tabla creada clientes");
        } else if (result == 0) {
            System.out.println("Tabla existe clientes");
        } else {
            System.out.println("Error clientes");
        }

        //tb -- trabajadores
        result = trabajadores();
        if (result == 1) {
            System.out.println("Tabla creada trabajadores");
        } else if (result == 0) {
            System.out.println("Tabla existe trabajadores");
        } else {
            System.out.println("Error trabajadores");
        }

        //tb -- maquinas
        result = maquinas();
        if (result == 1) {
            System.out.println("Tabla creada maquinas");
        } else if (result == 0) {
            System.out.println("Tabla existe maquinas");
        } else {
            System.out.println("Error maquinas");
        }

        //tb -- mantenimientos
        result = mantenimientos();
        if (result == 1) {
            System.out.println("Tabla creada mantenimientos");
        } else if (result == 0) {
            System.out.println("Tabla existe mantenimientos");
        } else {
            System.out.println("Error mantenimientos");
        }
        //tb -- maquinas_mantenimiento
        result = maquinas_mantenimiento();
        if (result == 1) {
            System.out.println("Tabla creada maquinas_mantenimiento");
        } else if (result == 0) {
            System.out.println("Tabla existe maquinas_mantenimiento");
        } else {
            System.out.println("Error maquinas_mantenimiento");
        }
        //tb -- reparaciones
        result = reparaciones();
        if (result == 1) {
            System.out.println("Tabla creada reparaciones");
        } else if (result == 0) {
            System.out.println("Tabla existe reparaciones");
        } else {
            System.out.println("Error reparaciones");
        }

        //tb -- usuarios
        result = usuarios();
        if (result == 1) {
            System.out.println("Tabla creada usuarios");
        } else if (result == 0) {
            System.out.println("Tabla existe usuarios");
        } else {
            System.out.println("Error usuarios");
        }

        //tb -- factura
        result = factura();
        if (result == 1) {
            System.out.println("Tabla creada factura");
        } else if (result == 0) {
            System.out.println("Tabla existe factura");
        } else {
            System.out.println("Error factura");
        }
    }

    private int trabajadores() {

        String s = "";
        s += "CREATE TABLE trabajadores";
        s += "(";
        s += "cc INT PRIMARY KEY,";
        s += "nombres VARCHAR(50),";
        s += "apellidos VARCHAR(50),";
        s += "celular VARCHAR(15),";
        s += "tipo VARCHAR(15) NOT NULL";
        s += ");";
        System.out.println(s);

        return conexion.crearTabla(s);

    }

    private int usuarios() {

        String s = "";
        s += "CREATE TABLE usuarios";
        s += "(";
        s += "id INT AUTO_INCREMENT PRIMARY KEY,";
        s += "email VARCHAR(30),";
        s += "contraseña VARCHAR(16),";
        s += "cc_trabajador INT UNIQUE,";
        s += "FOREIGN KEY(cc_trabajador) REFERENCES trabajadores(cc)";
        s += ");";
        return conexion.crearTabla(s);
    }

    private int maquinas() {

        String s = "";
        s += "CREATE TABLE maquinas";
        s += "(";
        s += "id INT AUTO_INCREMENT PRIMARY KEY,";
        s += "serial VARCHAR(20),";
        s += "modelo VARCHAR(20),";
        s += "marca VARCHAR(20),";
        s += "nombre VARCHAR(50),";
        s += "tipo VARCHAR(15) NOT NULL";
        s += ");";
        System.out.println(s);
        return conexion.crearTabla(s);
    }

    private int clientes() {

        String s = "";
        s += "CREATE TABLE clientes";
        s += "(";
        s += "cc INT PRIMARY KEY,";
        s += "nombre VARCHAR(20),";
        s += "apellido VARCHAR(20),";
        s += "telefono VARCHAR(20),";
        s += "tipo VARCHAR(15) NOT NULL";
        s += ");";
        System.out.println(s);
        return conexion.crearTabla(s);
    }

    private int mantenimientos() {

        String s = "";
        s += "CREATE TABLE mantenimientos";
        s += "(";
        s += "id INT AUTO_INCREMENT PRIMARY KEY,";
        s += "fecha VARCHAR(20),";
        s += "valor DOUBLE,";
        s += "cc_cliente INT,";
        s += "FOREIGN KEY (cc_cliente) REFERENCES clientes(cc)";
        s += ");";
        System.out.println(s);
        return conexion.crearTabla(s);
    }

    private int maquinas_mantenimiento() {

        String s = "";
        s += "CREATE TABLE maquinas_mantenimiento";
        s += "(";
        s += "id INT AUTO_INCREMENT PRIMARY KEY,";
        s += "id_mantenimiento INT,";
        s += "id_maquina INT,";
        s += "cc_trabajador INT,";
        s += "FOREIGN KEY(id_mantenimiento) REFERENCES mantenimientos(id),";
        s += "FOREIGN KEY(id_maquina) REFERENCES maquinas(id),";
        s += "FOREIGN KEY(cc_trabajador) REFERENCES trabajadores(cc)";
        s += ");";
        System.out.println(s);
        return conexion.crearTabla(s);
    }

    private int reparaciones() {

        String s = "";
        s += "CREATE TABLE reparaciones";
        s += "(";
        s += "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,";
        s += "descripcion VARCHAR(250),";
        s += "valor DOUBLE,";
        s += "id_maquina_mantenimiento INT,";
        s += "FOREIGN KEY(id_maquina_mantenimiento) REFERENCES maquinas_mantenimiento(id)";
        s += ");";
        System.out.println(s);
        return conexion.crearTabla(s);
    }
 

    private int factura() {

        String s = "";
        s += "CREATE TABLE factura";
        s += "(";
        s += "id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,";
        s += "id_mantenimiento INT,";
        s += "FOREIGN KEY(id_mantenimiento) REFERENCES mantenimientos(id)";
        s += ");";
        System.out.println(s);
        return conexion.crearTabla(s);
    }

    

}
