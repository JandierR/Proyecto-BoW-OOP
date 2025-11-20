package cr.ac.ucenfotec.rojas.jandier.dl;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Ticket;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Departamento> listaDepartamento;
    private List<Ticket> listaTickets;
    private List<Usuario> listaUsuario;
    private List<String> contrasenas;

    public Data() {
        listaDepartamento = new ArrayList<>();
        listaTickets = new ArrayList<>();
        listaUsuario = new ArrayList<>();
        contrasenas = new ArrayList<>();
    }

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public List<Ticket> getListaTickets() {
        return listaTickets;
    }

    public void setListaTickets(List<Ticket> listaTickets) {
        this.listaTickets = listaTickets;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<String> getContrasenas() {
        return contrasenas;
    }

    public void setContrasenas(List<String> contrasenas) {
        this.contrasenas = contrasenas;
    }

    public void agregarDepartamento(Departamento departamento) {
        listaDepartamento.add(departamento);
    }

    public void agregarUsuario(Usuario usuario) {
        listaUsuario.add(usuario);
    }

    public void agregarTicket(Ticket ticket) {
        listaTickets.add(ticket);
    }

}
