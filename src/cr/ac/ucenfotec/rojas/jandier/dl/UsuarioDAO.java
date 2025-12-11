package cr.ac.ucenfotec.rojas.jandier.dl;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Usuario dao.
 */
public class UsuarioDAO {

    /**
     * Insertar string.
     *
     * @param usuario the usuario
     * @return the string
     */
    public static String insertar(Usuario usuario) {
        /* CODIGO PARA SOLICITAR EL NOMBRE, LA CÉDULA Y LA EDAD DE UNA PERSONA. USANDO TRES VARIABLES.*/
        /* CODIGO PARA SOLICITAR EL NOMBRE, LA CÉDULA Y LA EDAD DE UNA PERSONA. USANDO TRES VARIABLES.*/


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null; // creando un objeto conexión.
            Statement stmt = null; // creaando un objeo statement.
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";

            //En el siguiente query, no puedo utilizar los getters de usuario que esta como parametro en este metodo insertar
//            String query = "INSERT INTO Usuario (id, nombreCompleto, correo, contrasena, telefono, rol) VALUES (usuario.getId(), 'Juan Pérez', 'juan@gmail.com', '1234', '23344230', 'Administrador')";
            String query = "INSERT INTO usuario (id, nombreCompleto, correo, contrasena, telefono, rol) VALUES ('" + usuario.getId() + "','" +
                    usuario.getNombreCompleto() + "','" + usuario.getCorreo() + "','" + usuario.getContrasena() + "','" + usuario.getTelefono() + "','" + usuario.getRol() + "')";
            conn = DriverManager.getConnection(conString);
            stmt = conn.createStatement();
            stmt.execute(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            return e.getMessage();
        }
        return "";
    }

    /**
     * Listar list.
     *
     * @return the list
     */
    public static List<Usuario> listar() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            String query = "SELECT id, nombreCompleto, correo, contrasena, telefono, rol FROM usuario";
            con = DriverManager.getConnection(conString);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Usuario usuarioTmp = new Usuario(
                        rs.getString("nombreCompleto"),
                        rs.getString("correo"),
                        rs.getString("contrasena"),
                        rs.getString("telefono"),
                        rs.getString("rol"),
                        rs.getInt("id")
                );
                usuarios.add(usuarioTmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuarios;
    }

    /**
     * Eliminar boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean eliminar(int id) {
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            con = DriverManager.getConnection(conString);

            stmt = con.createStatement();

            String query = "DELETE FROM usuario WHERE id = " + id;

            int filas = stmt.executeUpdate(query);
            return filas > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    /**
     * Modificar boolean.
     *
     * @param usuario the usuario
     * @return the boolean
     */
    public static boolean modificar(Usuario usuario) {
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            con = DriverManager.getConnection(conString);

            stmt = con.createStatement();

            String query = "UPDATE usuario SET "
                    + "nombreCompleto = '" + usuario.getNombreCompleto() + "', "
                    + "correo = '" + usuario.getCorreo() + "', "
                    + "contrasena = '" + usuario.getContrasena() + "', "
                    + "telefono = '" + usuario.getTelefono() + "', "
                    + "rol = '" + usuario.getRol() + "' "
                    + "WHERE id  = " + usuario.getId();

            int filas = stmt.executeUpdate(query);
            return filas > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
