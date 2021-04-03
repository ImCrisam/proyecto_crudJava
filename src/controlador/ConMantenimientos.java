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
import modelos.Cliente;
import modelos.Mantenimiento;
import modelos.Reparacion;
import modelos.Maquina;

import modelos.Maquinas_Mantenimiento;




public class ConMantenimientos {

    private Conexion conexion;

    public ConMantenimientos() {
        this.conexion = new Conexion();
    }

    public static String[] describe() {
        return new String[]{"id", "fecha", "valor", "cc Cliente"};
    }
    public void defaultData(){
       insert(new Mantenimiento("20-01-2021",50000 , 0));
       insert(new Mantenimiento("12-01-2021",250000 , 1));
       insert(new Mantenimiento("05-02-2021",150000 , 3));
        
    }
  
    public ArrayList<Mantenimiento> listar() {
        Statement st;
        ResultSet rs;
        ArrayList<Mantenimiento> result = new ArrayList<>();

        try {
            st = conexion.getCon().createStatement();
            rs = st.executeQuery("SELECT * "
                    + "FROM mantenimientos "
                    + "JOIN clientes "
                    + "ON mantenimientos.cc_cliente = clientes.cc");
            while (rs.next()) {
                result.add(
                        new Mantenimiento(
                                rs.getInt("id"),
                                rs.getString("fecha"),
                                rs.getDouble("valor"),
                                rs.getInt("cc_cliente"),
                                new Cliente(
                                        rs.getInt("cc"),
                                        rs.getString("nombre"),
                                        rs.getString("apellido"),
                                        rs.getString("telefono"),
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
    
    
        public ArrayList<Reparacion> listarAllReparacionesMantenimiento(int idMantenimiento) {
        Statement st;
        ResultSet rs;
        ArrayList<Reparacion> result = new ArrayList<>();

        try {
            st = conexion.getCon().createStatement();
            rs = st.executeQuery("SELECT * "
                    + "FROM reparaciones "
                    + "JOIN maquinas_mantenimiento "
                    + "ON reparaciones.id_maquina_mantenimiento = maquinas_mantenimiento.id "
                    + "JOIN maquinas "
                    + "ON maquinas_mantenimiento.id_maquina = maquinas.id "
                    + "WHERE maquinas_mantenimiento.id_mantenimiento = "+idMantenimiento
            );
            while (rs.next()) {
                
                result.add(
                        new Reparacion(
                                rs.getInt("id"),
                                rs.getString("descripcion"),
                                rs.getDouble("valor"),
                                rs.getInt("id_maquina_mantenimiento"),
                                new Maquinas_Mantenimiento(
                                        rs.getInt("id_maquina_mantenimiento"), 
                                        idMantenimiento, 
                                        rs.getInt("id_maquina"),
                                        rs.getInt("cc_trabajador"), 
                                        new Maquina(
                                                rs.getInt("id_maquina"), 
                                                rs.getString("serial"), 
                                                rs.getString("modelo"), 
                                                rs.getString("marca"),
                                                rs.getString("nombre"), 
                                                rs.getString("tipo")
                                        )
                                )
                            
                        )
                );
            }
            conexion.cerrar();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return result;
    }

    public int insert(Mantenimiento modelo) {
        String sql = "INSERT INTO mantenimientos"
                + " (id,"
                + " fecha,"
                + " valor,"
                + " cc_cliente)"
                + " VALUES ( ?, ?, ?, ?)";

        PreparedStatement statement;
        try {
            statement = conexion.getCon().prepareStatement(sql);
            statement.setInt(1, modelo.getId());
            statement.setString(2, modelo.getFecha());
            statement.setDouble(3, modelo.getValor());
            statement.setInt(4, modelo.getCc_cliente());

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
    
      public boolean update(Mantenimiento modelo) {

        try {
            String sql = "UPDATE mantenimientos "
                    + "SET fecha=?, "
                    + "valor=?, "
                    + "cc_cliente=? "
                    + "WHERE id=?";
            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setString(1, modelo.getFecha());
            statement.setDouble(2, modelo.getValor());
            statement.setInt(3, modelo.getCc_cliente());
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
      
          public boolean delete(Mantenimiento modelo) {

        try {
            String sql = "DELETE FROM Mantenimiento WHERE id=?";

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
