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

public class ConClientes {

    private Conexion conexion;

    public ConClientes() {
        this.conexion = new Conexion();
    }

    public static String[] describe() {
        return new String[]{
            "CC",
            "Nombre",
            "Apellido",
            "Telefono",
            "Tipo",};
    }
    
    public void defaultData(){
        insert(new Cliente(0, "Andres", "Silvia", "3014561010", "Natural"));
        insert(new Cliente(1, "Raul", "Perez", "3101232002", "Juridico"));
        insert(new Cliente(2, "Juan", "Garcia", "3014561010", "Natural"));
        insert(new Cliente(3, "Daniel", "Perez", "3101232002", "Juridico"));
        insert(new Cliente(4, "Oscar", "Martin", "3014561010", "Natural"));
        insert(new Cliente(5, "Maria", "Lopez", "3101232002", "Juridico"));
    }

    public ArrayList<Cliente> listar() {
        Statement st;
        ResultSet rs;
        ArrayList<Cliente> result = new ArrayList<>();

        try {
            st = conexion.getCon().createStatement();
            rs = st.executeQuery("select * from clientes");
            while (rs.next()) {
                result.add(
                        new Cliente(
                                rs.getInt("cc"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getString("telefono"),
                                rs.getString("tipo"))
                );
            }
            conexion.cerrar();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return result;
    }

    public int insert(Cliente modelo) {
        String sql = "INSERT INTO clientes ("
                + "cc, "
                + "nombre, "
                + "apellido, "
                + "telefono, "
                + "tipo) "
                + "VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement;
        try {
            statement = conexion.getCon().prepareStatement(sql);
            statement.setInt(1, modelo.getCc());
            statement.setString(2, modelo.getNombre());
            statement.setString(3, modelo.getApellido());
            statement.setString(4, modelo.getCelular());
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

    public boolean update(Cliente modelo) {

        try {
            String sql = "UPDATE clientes "
                    + "SET "
                    + "nombre=?, "
                    + "apellido=?, "
                    + "telefono=?, "
                    + "tipo=? "
                    + "WHERE cc=?";
            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setString(1, modelo.getNombre());
            statement.setString(2, modelo.getApellido());
            statement.setString(3, modelo.getCelular());
            statement.setString(4, modelo.getTipo());
            statement.setInt(5, modelo.getCc());

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
    
    public boolean delete(Cliente modelo) {

        try {
            String sql = "DELETE FROM clientes WHERE cc=?";

            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setInt(1, modelo.getCc());

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
