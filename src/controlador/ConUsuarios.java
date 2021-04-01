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
import modelos.Usuario;
import modelos.Trabajador;

public class ConUsuarios {

    private Conexion conexion;

    public ConUsuarios() {
        this.conexion = new Conexion();
    }

    public static String[] describe() {
        return new String[]{"id", "Email", "cc"};
    }

    public void defaultData() {
        insert(new Usuario("virginia@gmail.com", "16480224", 16480224));
        insert(new Usuario("1234", "1234", 1234));

        insert(new Usuario("Brendan@gmail.com", "16490213", 16490213));
        insert(new Usuario("Laith@gmail.com", "16540209", 16540209));
    }

    public Usuario login(String email, String contraseña) {
        Statement st;
        ResultSet rs;
        try {
            String s = "select * "
                    + "from usuarios "
                    + "JOIN trabajadores "
                    + "ON usuarios.cc_trabajador = trabajadores.cc "
                    + "WHERE usuarios.email='" + email + "'";

            System.out.println(s);
            st = conexion.getCon().createStatement();
            rs = st.executeQuery(s);

            System.out.println(rs.next());
            Usuario user = new Usuario(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("contraseña"),
                    rs.getInt("cc_trabajador"),
                    new Trabajador(
                            rs.getInt("cc_trabajador"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("celular"),
                            rs.getString("tipo")));

            conexion.cerrar();
            System.out.println(user.getTrabajador().getApellido());
            return user;
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return null;
    }

    public ArrayList<Usuario> listar() {
        Statement st;
        ResultSet rs;
        ArrayList<Usuario> result = new ArrayList<>();

        try {
            st = conexion.getCon().createStatement();
            rs = st.executeQuery("select * from usuarios");
            while (rs.next()) {
                result.add(
                        new Usuario(
                                rs.getInt("id"),
                                rs.getString("email"),
                                rs.getString("contraseña"),
                                rs.getInt("cc_trabajador"))
                );
            }
            conexion.cerrar();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return result;
    }

    public int insert(Usuario modelo) {
        String sql = "INSERT INTO usuarios (email, contraseña, cc_trabajador) VALUES ( ?, ?, ?)";

        PreparedStatement statement;
        try {
            statement = conexion.getCon().prepareStatement(sql);
            statement.setString(1, modelo.getEmail());
            statement.setString(2, modelo.getContraseña());
            statement.setInt(3, modelo.getCc_trabajador());
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

    public boolean update(Usuario modelo) {

        try {
            String sql = "UPDATE usuarios SET email=?, contraseña=?, cc_trabajador=? WHERE id=?";
            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setString(1, modelo.getEmail());
            statement.setString(2, modelo.getContraseña());
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

    public boolean delete(Usuario modelo) {

        try {
            String sql = "DELETE FROM usuarios WHERE id=?";

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
