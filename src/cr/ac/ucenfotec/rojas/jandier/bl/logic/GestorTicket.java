package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Ticket;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;
import cr.ac.ucenfotec.rojas.jandier.dl.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestorTicket {

    private Data data;

    public GestorTicket(Data data) {
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

        //Verifica si existe un usuario y departamento con el id ingresado
        Usuario usuario = gestorUsuario.buscarPorId(data.getListaUsuario(), idUsuario);
        Departamento departamento = gestorDepartamento.buscarPorId(data.getListaDepartamento(), idDepartamento);

        if (usuario == null || departamento == null) {
            return "Lo sentimos, este usuario o este departamento no existe";
        }

        if (!estado.equalsIgnoreCase("Nuevo") &&
                !estado.equalsIgnoreCase("En progreso") &&
                !estado.equalsIgnoreCase("Resuelto")) {
            return "Por favor, ingresar un estado valido";
        }
        data.agregarTicket(new Ticket(id, asunto, descripcion, estado, usuario, departamento));
        return "Ticket registrado exitosamente";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        GestorTicket that = (GestorTicket) object;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}
