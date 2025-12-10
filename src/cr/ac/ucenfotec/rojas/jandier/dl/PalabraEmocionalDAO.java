package cr.ac.ucenfotec.rojas.jandier.dl;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.PalabraEmocional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PalabraEmocionalDAO {

    public PalabraEmocionalDAO() {
    }

    public static String insertar(PalabraEmocional palabraEmocional){

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null; // creando un objeto conexión.
            Statement stmt = null; // creaando un objeo statement.
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";


            String query = "INSERT INTO PalabraEmocional (palabra, tipoEmocion) VALUES ('" + palabraEmocional.getPalabra() + "','" +
                    palabraEmocional.getTipo() +"')";
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

    public static List<PalabraEmocional> listar() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<PalabraEmocional> palabrasEmocionales = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            String query = "SELECT palabra, tipoEmocion FROM PalabraEmocional";
            con = DriverManager.getConnection(conString);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                PalabraEmocional palabraEmocionalTmp = new PalabraEmocional(
                        rs.getString("palabra"),
                        rs.getString("tipoEmocion")
                );
                palabrasEmocionales.add(palabraEmocionalTmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return palabrasEmocionales;
    }
}
