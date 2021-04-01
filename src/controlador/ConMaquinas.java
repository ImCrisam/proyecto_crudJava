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
import modelos.Maquina;

public class ConMaquinas {

    private Conexion conexion;

    public ConMaquinas() {
        this.conexion = new Conexion();
    }

    public static String[] describe() {
        return new String[]{
            "ID",
            "Serial",
            "Modelo",
            "Marca",
            "Nombre",
            "Tipo",};
    }

    public void defaultData(){
        insert(new Maquina("CAT1230321", "NN", "Caterpillar", "Caterpillar CAT 123", "Excavadora"));
        insert(new Maquina("JD580K", "NN", "John Deere", "John Deere 580K", "Retroexcavadora"));
        insert(new Maquina("NH520A", "NN", "New Holland", "\"New Holland 520A", "Vibrocompactador"));
    }
    
    public ArrayList<Maquina> listar() {
        Statement st;
        ResultSet rs;
        ArrayList<Maquina> result = new ArrayList<>();

        try {
            st = conexion.getCon().createStatement();
            rs = st.executeQuery("select * from maquinas");
            while (rs.next()) {
                result.add(
                        new Maquina(
                                rs.getInt("id"),
                                rs.getString("serial"),
                                rs.getString("modelo"),
                                rs.getString("marca"),
                                rs.getString("nombre"),
                                rs.getString("tipo"))
                );
            }
            conexion.cerrar();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return result;
    }

    public int insert(Maquina modelo) {
        String sql = "INSERT INTO maquinas ("
                + "serial, "
                + "modelo, "
                + "marca, "
                + "nombre, "
                + "tipo) "
                + "VALUES ( ?, ?, ?, ?, ?)";

        PreparedStatement statement;
        try {
            statement = conexion.getCon().prepareStatement(sql);
            statement.setString(1, modelo.getSerie());
            statement.setString(2, modelo.getModelo());
            statement.setString(3, modelo.getMarca());
            statement.setString(4, modelo.getNombre());
            statement.setString(5, modelo.getTipo());
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
    
     public boolean update(Maquina modelo) {

        try {
            String sql = "UPDATE maquinas "
                    + "SET serial=?, "
                    + "modelo=?, "
                    + "marca=?, "
                    + "nombre=?, "
                    + "tipo=? "
                    + "WHERE id=?";
            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setString(1, modelo.getSerie());
            statement.setString(2, modelo.getModelo());
            statement.setString(1, modelo.getMarca());
            statement.setString(2, modelo.getNombre());
            statement.setString(1, modelo.getTipo());
            statement.setInt(4, modelo.getId());

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
     
         public boolean delete(Maquina modelo) {

        try {
            String sql = "DELETE FROM maquinas WHERE id=?";

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
