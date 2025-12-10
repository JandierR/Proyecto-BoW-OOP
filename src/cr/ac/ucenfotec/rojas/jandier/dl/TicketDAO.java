package cr.ac.ucenfotec.rojas.jandier.dl;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Ticket;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;
import cr.ac.ucenfotec.rojas.jandier.bl.logic.GestorDepartamento;
import cr.ac.ucenfotec.rojas.jandier.bl.logic.GestorUsuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public TicketDAO() {
    }

    public static String insertar(Ticket ticket){

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = null; // creando un objeto conexión.
            Statement stmt = null; // creaando un objeo statement.
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";


            String query = "INSERT INTO Ticket (id, asunto, descripcion, estado, usuario_id, departamento_id) VALUES ('" + ticket.getId() + "','" +
                    ticket.getAsunto() + "','" + ticket.getDescripcion() + "','" + ticket.getEstado()
                    + "','" + ticket.getUsuario().getId() + "','" + ticket.getDepartamento().getId() +"')";
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

    public static List<Ticket> listar() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conString = "jdbc:sqlserver://localhost:1433;DatabaseName=HelpDeskU;user=sa;password=Lolypop88*;encrypt=false";
            String query = "SELECT id, asunto, descripcion, estado, usuario_id, departamento_id FROM Ticket";
            con = DriverManager.getConnection(conString);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                int idUsuario = rs.getInt("usuario_id");
                int idDepartamento = rs.getInt("departamento_id");

                GestorUsuario gestorUsuario = new GestorUsuario();
                Usuario usuario = gestorUsuario.buscarPorId(idUsuario);

                GestorDepartamento gestorDepartamento = new GestorDepartamento();
                Departamento departamento = gestorDepartamento.buscarPorId(idDepartamento);



                Ticket ticketTmp = new Ticket(
                        rs.getInt("id"),
                        rs.getString("asunto"),
                        rs.getString("descripcion"),
                        rs.getString("estado"),
                        usuario,
                        departamento
                );
                tickets.add(ticketTmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tickets;
    }
}
