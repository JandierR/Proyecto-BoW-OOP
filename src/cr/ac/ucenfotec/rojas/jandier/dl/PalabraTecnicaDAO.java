package cr.ac.ucenfotec.rojas.jandier.dl;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.PalabraTecnica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PalabraTecnicaDAO {
    public PalabraTecnicaDAO() {
    }

    public static String insertar(PalabraTecnica palabraTecnica) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null; // creando un objeto conexión.
            Statement stmt = null; // creaando un objeo statement.
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";


            String query = "INSERT INTO PalabraTecnica (palabra, categoria) VALUES ('" + palabraTecnica.getPalabra() + "','" +
                    palabraTecnica.getCategoria() + "')";
            conn = DriverManager.getConnection(conString);
            stmt = conn.createStatement();
            stmt.execute(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error";
        }
        return "";
    }

    public static List<PalabraTecnica> listar() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<PalabraTecnica> palabraTecnicas = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            String query = "SELECT palabra, categoria FROM PalabraTecnica";
            con = DriverManager.getConnection(conString);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                PalabraTecnica palabraTecnicaTmp = new PalabraTecnica(
                        rs.getString("palabra"),
                        rs.getString("categoria")
                );
                palabraTecnicas.add(palabraTecnicaTmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return palabraTecnicas;
    }

    public static boolean eliminar(String palabra) {
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            con = DriverManager.getConnection(conString);

            stmt = con.createStatement();

            String query = "DELETE FROM PalabraTecnica WHERE palabra = '" + palabra + "'";

            int filas = stmt.executeUpdate(query);
            return filas > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

    }

    public static boolean modificar(PalabraTecnica palabraTecnica) {
        Connection con = null;
        Statement stmt = null;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            con = DriverManager.getConnection(conString);

            stmt = con.createStatement();

            String query = "UPDATE PalabraTecnica SET "
                    + "categoria = '" + palabraTecnica.getCategoria() + "' "
                    + "WHERE palabra  = '" + palabraTecnica.getPalabra() + "'";

            int filas = stmt.executeUpdate(query);
            return filas > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
