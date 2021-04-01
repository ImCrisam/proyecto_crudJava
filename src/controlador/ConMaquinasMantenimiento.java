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
import modelos.Maquinas_Mantenimiento;
import modelos.Trabajador;

import modelos.Maquina;

public class ConMaquinasMantenimiento {

    private Conexion conexion;

    public ConMaquinasMantenimiento() {
        this.conexion = new Conexion();
    }

    public static String[] describe() {
        return new String[]{"id", "id maquina", "cc trabajador"};
    }
     public void defaultData(){
        //insert(new Maquina("CAT1230321", "NN", "Caterpillar", "Caterpillar CAT 123", "Excavadora"));
        
    }

    public ArrayList<Maquinas_Mantenimiento> listar() {
        Statement st;
        ResultSet rs;
        ArrayList<Maquinas_Mantenimiento> result = new ArrayList<>();

        try {
            st = conexion.getCon().createStatement();
            rs = st.executeQuery("SELECT * "
                    + "FROM maquinas_mantenimiento "
                    + "JOIN maquinas "
                    + "ON maquinas_mantenimiento.id_maquina = maquinas.id"
                    + "JOIN trabajadores "
                    + "ON maquinas_mantenimiento.cc_trabajadores = trabajadores.cc");
            while (rs.next()) {
                result.add(
                        new Maquinas_Mantenimiento(
                                rs.getInt("id"),
                                rs.getInt("id_mantenimiento"),
                                rs.getInt("id_maquina"),
                                rs.getInt("cc_trabajador"),
                                new Trabajador(
                                        rs.getInt("cc"),
                                        rs.getString("nombres"),
                                        rs.getString("apellidos"),
                                        rs.getString("celular"),
                                        rs.getString("tipo")),
                                new Maquina(
                                        rs.getInt("id_maquina"),
                                        rs.getString("serial"),
                                        rs.getString("modelo"),
                                        rs.getString("marca"),
                                        rs.getString("nombre"),
                                        rs.getString("tipo"))
                        )
                );
            }
            conexion.cerrar();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return result;
    }

    public int insert(Maquinas_Mantenimiento modelo) {
        String sql = "INSERT INTO maquinas_mantenimiento"
                + " (id,"
                + " id_mantenimiento,"
                + " id_maquina,"
                + " cc_trabajador)"
                + " VALUES ( ?, ?, ?, ?)";

        PreparedStatement statement;
        try {
            statement = conexion.getCon().prepareStatement(sql);
            statement.setInt(1, modelo.getId());
            statement.setInt(2, modelo.getId_mantenimiento());
            statement.setInt(3, modelo.getId_maquina());
            statement.setInt(4, modelo.getCc_trabajador());

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

    public boolean update(Maquinas_Mantenimiento modelo) {

        try {
            String sql = "UPDATE maquinas_mantenimiento "
                    + "SET id_mantenimiento=?, "
                    + "id_maquina=?, "
                    + "cc_trabajador=? "
                    + "WHERE id=?";
            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setInt(1, modelo.getId_mantenimiento());
            statement.setInt(2, modelo.getId_maquina());
            statement.setInt(3, modelo.getCc_trabajador());
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

    public boolean delete(Maquinas_Mantenimiento modelo) {

        try {
            String sql = "DELETE FROM maquinas_mantenimiento WHERE id=?";

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
