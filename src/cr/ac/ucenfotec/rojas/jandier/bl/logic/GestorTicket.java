package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Ticket;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestorTicket {
    private List<Ticket> listaTickets;

    public GestorTicket() {
        listaTickets = new ArrayList<>();
    }

    //Este metodo registra los tickets en base a sus atributos ingresados como parametros (argumentos en ejecucion)
    public void registrarTicket(int id, String asunto, String descripcion, String estado, int idUsuario, int idDepartamento) {
        GestorUsuario gestorUsuario = new GestorUsuario();
        GestorDepartamento gestorDepartamento = new GestorDepartamento();

        //Verifica si existe un usuario con el id ingresado
        Usuario usuario = gestorUsuario.buscarPorId(gestorUsuario.getListaUsuario(), idUsuario);

        //Verifica si existe un departamento con el id ingresado
        Departamento departamento = gestorDepartamento.buscarPorId(gestorDepartamento.getListaDepartamento(), idDepartamento);

        listaTickets.add(new Ticket(id, asunto, descripcion, estado, usuario, departamento));
    }

    public List<Ticket> getListaTickets() {
        return listaTickets;
    }
}
