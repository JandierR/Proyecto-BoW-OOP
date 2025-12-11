package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Ticket;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;
import cr.ac.ucenfotec.rojas.jandier.dl.TicketDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Gestor ticket.
 */
public class GestorTicket {

//    private Data data;
//
//    public GestorTicket(Data data) {
//        this.data = data;
//    }


    /**
     * Instantiates a new Gestor ticket.
     */
    public GestorTicket() {
    }

    /**
     * Obtener tickets list.
     *
     * @return the list
     */
    public List<String> obtenerTickets() {
        List<String> resultado = new ArrayList<>();
        List<Ticket> tickets = TicketDAO.listar();
        if (tickets.isEmpty()) {
            resultado.add("[Lista vacía]");
            return resultado;
        }
        for (Ticket ticket : tickets) {
            resultado.add(ticket.toString());
        }
        return resultado;    }


    /**
     * Registrar ticket string.
     *
     * @param id             the id
     * @param asunto         the asunto
     * @param descripcion    the descripcion
     * @param estado         the estado
     * @param idUsuario      the id usuario
     * @param idDepartamento the id departamento
     * @return the string
     */
//Este metodo registra los tickets en base a sus atributos ingresados como parametros (argumentos en ejecucion)
    public String registrarTicket(int id, String asunto, String descripcion, String estado, int idUsuario, int idDepartamento) {
        GestorUsuario gestorUsuario = new GestorUsuario();
        GestorDepartamento gestorDepartamento = new GestorDepartamento();

        //Verifica si existe un usuario y departamento con el id ingresado
        Usuario usuario = gestorUsuario.buscarPorId(idUsuario);
        Departamento departamento = gestorDepartamento.buscarPorId(idDepartamento);

        if (usuario == null || departamento == null) {
            return "Lo sentimos, este usuario o este departamento no existe";
        }

        if (!estado.equalsIgnoreCase("Nuevo") &&
                !estado.equalsIgnoreCase("En progreso") &&
                !estado.equalsIgnoreCase("Resuelto")) {
            return "Por favor, ingresar un estado valido";
        }
//        data.agregarTicket(new Ticket(id, asunto, descripcion, estado, usuario, departamento));
        TicketDAO.insertar(new Ticket(id, asunto, descripcion, estado, usuario, departamento));
        return "Ticket registrado exitosamente";
    }

    /**
     * Eliminar ticket string.
     *
     * @param id the id
     * @return the string
     */
    public String eliminarTicket(int id) {
        boolean eliminado = TicketDAO.eliminar(id);
        return eliminado ? "Ticket eliminado correctamente" : "No se encontro ese ticket";
    }

    /**
     * Modificar ticket string.
     *
     * @param ticket the ticket
     * @return the string
     */
    public String modificarTicket(Ticket ticket) {
        boolean modificado = TicketDAO.modificar(ticket);
        return modificado ? "Ticket modificado exitosamente" : "No se encontro ese ticket";
    }


}
