/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.Reparacion;



public class ConReparaciones {
    
     private Conexion conexion;

    public ConReparaciones() {
        this.conexion = new Conexion();
    }
    
     public static String[] describe() {
        return new String[]{
            "ID",
            "Descrip",
            "Valor"};
    }
     
      public void defaultData() {
        insert(new Reparacion("oret amet consectetur adipiscing elit non orci montes vehicula parturient",
                500.00,
                0));
        insert(new Reparacion("orem ipsum dolor sit amet consectetur adiicula mauris parturient",
                100.00,
                0));
        insert(new Reparacion("orem ipsum dolor sitn orci montes vehicula mauris parturient",
                1500.00,
                1));
        insert(new Reparacion("orem ipsum dolor sitn orci montes vehicula adipiscing elit non orci m mauris paient",
                150.00,
                1));
        insert(new Reparacion("orem ipsum dolor sitn orci montes vehicula mauris parturient",
                50.00,
                2));
    }
     
      public ArrayList<Reparacion> listar() {
        Statement st;
        ResultSet rs;
        ArrayList<Reparacion> result = new ArrayList<>();

        try {
            st = conexion.getCon().createStatement();
            rs = st.executeQuery("select * from reparaciones");
            while (rs.next()) {
                result.add(
                        new Reparacion(
                                rs.getInt("id"),
                                rs.getString("descripcion"),
                                rs.getDouble("valor"),
                                rs.getInt("id_maquina_mantenimiento"))
                );
            }
            conexion.cerrar();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return result;
    }
      
      
       public int insert(Reparacion modelo) {
        String sql = "INSERT INTO reparaciones "
                + "(descripcion,"
                + " valor,"
                + " id_maquina_mantenimiento) "
                + "VALUES (?, ?, ?)";

        PreparedStatement statement;
        try {
            statement = conexion.getCon().prepareStatement(sql);
            statement.setString(1, modelo.getDescripcion());
            statement.setDouble(2, modelo.getValor());
            statement.setInt(3, modelo.getId_maquina_mantenimiento());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return 1;
            }
            statement.close();
            conexion.cerrar();
            return 1;
        } catch (SQLException ex) {
            if (ex.getMessage().contains("Duplicate")) {
                return 0;
            }
            System.err.println(ex);
            return -1;
        }

    }

    public boolean update(Reparacion modelo) {

        try {
            String sql = "UPDATE reparaciones "
                    + "SET "
                    + "descripcion=?, "
                    + "valor=?, "
                    + "id_maquina_mantenimiento=? "
                    + "WHERE id=?";
            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setString(1, modelo.getDescripcion());
            statement.setDouble(2, modelo.getValor());
            statement.setInt(3, modelo.getId_maquina_mantenimiento());
            statement.setInt(5, modelo.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
            }
            statement.close();
            conexion.cerrar();
            return true;

        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }
    
    public boolean delete(Reparacion modelo) {

        try {
            String sql = "DELETE FROM reparaciones WHERE id=?";

            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setInt(1, modelo.getId());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }
            statement.close();
            conexion.cerrar();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex);
            return false;
        }
    }

     
    
}