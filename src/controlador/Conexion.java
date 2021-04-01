/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class Conexion {

    private Connection con;
    private PreparedStatement stmt;
    private String s;

    public int crearTabla(String s) {
        try {
            //Crea tabla trabajadores
            con = getCon();
            stmt = con.prepareStatement(s);
            stmt.execute();
            stmt.close();
            cerrar();
            return 1;
        } catch (Exception e) {
            if (e.getMessage().contains("already exists")) {
                return 0;
            } else {
                System.err.println("Error:" + e.getMessage());
                return -1;
            }
        }
    }

    protected Connection getCon() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            throw new SQLException("Driver de BD no disponible en classpath");
        }

        if (con == null || con.isClosed()) {
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com/ZsP67MY4Ok", "ZsP67MY4Ok", "d74cm0Hfur");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto2","root", "");

            System.out.println("Conexion exitosa");
        }

        return con;
    }

    protected void cerrar() {

        if (con != null) {
            try {
                con.close();
            } catch (Exception ignored) {
                // aqui solo ignoramos, ya que no nos importa si da error al momento de cerrar la conexion
            }
        }
    }
}
