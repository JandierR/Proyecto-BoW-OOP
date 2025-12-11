package cr.ac.ucenfotec.rojas.jandier.dl;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    public DepartamentoDAO() {
    }

    public static String insertar(Departamento departamento){

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null; // creando un objeto conexión.
            Statement stmt = null; // creaando un objeo statement.
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";


            String query = "INSERT INTO Departamento (nombreDepartamento, descripcion, correo, id) VALUES ('" + departamento.getNombreDepartamento() + "','" +
                    departamento.getDescripcion() + "','" + departamento.getCorreo() + "','" + departamento.getId() + "')";
            conn = DriverManager.getConnection(conString);
            stmt = conn.createStatement();
            stmt.execute(query);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Error";
        }
        return "";
    }

    public static List<Departamento> listar() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Departamento> departamentos = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            String query = "SELECT nombreDepartamento, descripcion, correo, id FROM Departamento";
            con = DriverManager.getConnection(conString);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                Departamento departamentoTmp = new Departamento(
                        rs.getString("nombreDepartamento"),
                        rs.getString("descripcion"),
                        rs.getString("correo"),
                        rs.getInt("id")
                );
                departamentos.add(departamentoTmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return departamentos;
    }

    public static boolean eliminar(int id) {
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            con = DriverManager.getConnection(conString);

            stmt = con.createStatement();

            String query = "DELETE FROM Departamento WHERE id = " + id;

            int filas = stmt.executeUpdate(query);
            return filas > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean modificar(Departamento departamento) {
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            con = DriverManager.getConnection(conString);

            stmt = con.createStatement();

            String query = "UPDATE Departamento SET "
                    + "nombreDepartamento = '" + departamento.getNombreDepartamento() + "', "
                    + "descripcion = '" + departamento.getDescripcion() + "', "
                    + "correo = '" + departamento.getCorreo() + "' "
                    + "WHERE id  = " + departamento.getId();

            int filas = stmt.executeUpdate(query);
            return filas > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
