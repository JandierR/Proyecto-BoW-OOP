package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Ticket;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class TicketManager {
    private List<Ticket> listaTickets;

    public TicketManager() {
        listaTickets = new ArrayList<>();
    }

    public void registrarTicket(int id, String asunto, String descripcion, String estado, Usuario usuario, Departamento departamento) {
        listaTickets.add(new Ticket(id, asunto, descripcion, estado, usuario, departamento));
    }

    public List<Ticket> getListaTickets() {
        return listaTickets;
    }
}
