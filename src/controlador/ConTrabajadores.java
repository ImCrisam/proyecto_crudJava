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
import modelos.Trabajador;


public class ConTrabajadores {

    private Conexion conexion;

    public ConTrabajadores() {
        this.conexion = new Conexion();
    }

    public static String[] describe() {
        return new String[]{"Cedula", "Nombre", "Apellidos", "Celular", "Tipo"};
    }
    
    public void defaultData() {
        insert(new Trabajador(00000000, "Admin", "user", "", "Admin"));
        insert(new Trabajador(16480224, "Virginia", "Frazier", "698-3216340", "Maecenas"));
        insert(new Trabajador(16490213, "Brendan", "Robinson", "587-4581451", "In"));
        insert(new Trabajador(16540209, "Laith", "Webster", "179-4068032", "eu,"));
        insert(new Trabajador(16950904, "Regan", "Figueroa", "761-1343667", "odio"));
        insert(new Trabajador(16660711, "Jennifer", "Duffy", "057-5625366", "tellus"));
        insert(new Trabajador(16810820, "Gray", "Vang", "430-6594179", "Sed"));
        insert(new Trabajador(16690911, "Clinton", "Cameron", "738-3663485", "laoreet,"));
        insert(new Trabajador(16080524, "Emi", "Rich", "981-9963567", "risus."));
        insert(new Trabajador(16341220, "Barclay", "Figueroa", "987-5896584", "sollicitudin"));
        insert(new Trabajador(16910407, "Laura", "Chambers", "818-0577586", "convallis"));
        insert(new Trabajador(16430907, "Quinn", "Randall", "868-3412919", "Nulla"));
        insert(new Trabajador(16010408, "Ariel", "Key", "654-9142426", "auctor"));
        insert(new Trabajador(16041102, "Bell", "Greene", "519-4964226", "Integer"));
        insert(new Trabajador(16800312, "Frances", "Ryan", "667-9187957", "metus."));
        insert(new Trabajador(16170119, "Deanna", "Gibson", "083-1066229", "Nunc"));
        insert(new Trabajador(16840519, "Keane", "Hayes", "045-0950805", "tortor."));
        insert(new Trabajador(16170724, "Connor", "Wong", "398-5431403", "magna."));
        insert(new Trabajador(16360929, "Ferdinand", "Craft", "822-6574200", "ornare,"));
        insert(new Trabajador(16330526, "Ryan", "Cooke", "388-9903432", "scelerisque"));

    }
    
     public ArrayList<Trabajador> listar() {
        Statement st;
        ResultSet rs;
        ArrayList<Trabajador> result = new ArrayList<>();
        
        try {
            st = conexion.getCon().createStatement();
            rs = st.executeQuery("select * from trabajadores");
            while (rs.next()) {
                result.add(
                        new Trabajador(
                                rs.getInt("cc"),
                                rs.getString("nombres"),
                                rs.getString("apellidos"),
                                rs.getString("celular"),
                                rs.getString("tipo"))
                );
            }
            conexion.cerrar();
        } catch (SQLException e) {
            System.err.println("Error:" + e);
        }
        return result;
    }
     
       public int insert(Trabajador trabajador) {
        String sql = "INSERT INTO trabajadores (cc, nombres, apellidos, celular, tipo) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement statement;
        try {
            statement = conexion.getCon().prepareStatement(sql);
            statement.setInt(1, trabajador.getCc());
            statement.setString(2, trabajador.getNombre());
            statement.setString(3, trabajador.getApellido());
            statement.setString(4, trabajador.getCelular());
            statement.setString(5, trabajador.getTipo());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                return 1;
            }
            statement.close();
            conexion.cerrar();
            return 1;
        } catch (SQLException ex) {
            if(ex.getMessage().contains("Duplicate")){
            return 0;
            }
            System.err.println(ex);
            return -1;
        }

    }
       
       
    public boolean update(Trabajador trabajador) {

        try {
            String sql = "UPDATE trabajadores SET nombres=?, apellidos=?, celular=?, tipo=? WHERE cc=?";
            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setString(1, trabajador.getNombre());
            statement.setString(2, trabajador.getApellido());
            statement.setString(3, trabajador.getCelular());
            statement.setString(4, trabajador.getTipo());
            statement.setInt(5, trabajador.getCc());

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
    
      public int delete(Trabajador trabajador) {

        try {
            String sql = "DELETE FROM trabajadores WHERE cc=?";

            PreparedStatement statement = conexion.getCon().prepareStatement(sql);
            statement.setInt(1, trabajador.getCc());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
            }
                System.out.println(rowsDeleted);
            statement.close();
            conexion.cerrar();
            return 1;
        } catch (SQLException ex) {
             if (ex.getMessage().contains("foreign key")) {
                return 0;
            }
            System.err.println(ex);
            return -1;
        }
    }

}
