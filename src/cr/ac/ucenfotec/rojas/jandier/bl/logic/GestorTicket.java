package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Ticket;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;
import cr.ac.ucenfotec.rojas.jandier.dl.Data;

import java.util.ArrayList;
import java.util.List;

public class GestorTicket {
//    private List<Ticket> listaTickets;

    private Data data;

    public GestorTicket(Data data) {
//        listaTickets = new ArrayList<>();
        this.data = data;
    }
    public List<String> obtenerTickets() {
        List<String> resultado = new ArrayList<>();
        if (data.getListaTickets().isEmpty()) {
            resultado.add("[Lista vacía]");
            return resultado;
        }
        for (Ticket ticket : data.getListaTickets()) {
            resultado.add(ticket.toString());
        }
        return resultado;    }


    //Este metodo registra los tickets en base a sus atributos ingresados como parametros (argumentos en ejecucion)
    public String registrarTicket(int id, String asunto, String descripcion, String estado, int idUsuario, int idDepartamento) {
        GestorUsuario gestorUsuario = new GestorUsuario(data);
        GestorDepartamento gestorDepartamento = new GestorDepartamento(data);

        //Verifica si existe un usuario con el id ingresado
        Usuario usuario = gestorUsuario.buscarPorId(data.getListaUsuario(), idUsuario);

        if (usuario == null) {
            return "Lo sentimos, este usuario no existe";
        }

        //Verifica si existe un departamento con el id ingresado
        Departamento departamento = gestorDepartamento.buscarPorId(data.getListaDepartamento(), idDepartamento);

        if (departamento == null) {
            return "Lo sentimos, este departamento no existe";
        }

        if (!estado.equalsIgnoreCase("Nuevo") &&
                !estado.equalsIgnoreCase("En progreso") &&
                !estado.equalsIgnoreCase("Resuelto")) {
            return "Por favor, ingresar un estado valido";
        }
        data.agregarTicket(new Ticket(id, asunto, descripcion, estado, usuario, departamento));
        return "Ticket registrado exitosamente";
    }

}
