package cr.ac.ucenfotec.rojas.jandier.dl;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Departamento> listaDepartamento;
    private List<Ticket> listaTickets;
    private List<Usuario> listaUsuario;
    private List<String> contrasenas;
    private List<PalabraTecnica> listaPalabrasTecnicas;
    private List<PalabraEmocional> listaPalabrasEmocionales;

    public Data() {
        listaDepartamento = new ArrayList<>();
        listaTickets = new ArrayList<>();
        listaUsuario = new ArrayList<>();
        contrasenas = new ArrayList<>();
        listaPalabrasTecnicas = new ArrayList<>();
        listaPalabrasEmocionales = new ArrayList<>();
    }

    //No debe de retornar departamento, debe de retornar String segun el profe
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

    public List<PalabraTecnica> getListaPalabrasTecnicas() {
        return listaPalabrasTecnicas;
    }

    public void setListaPalabrasTecnicas(List<PalabraTecnica> listaPalabrasTecnicas) {
        this.listaPalabrasTecnicas = listaPalabrasTecnicas;
    }

    public List<PalabraEmocional> getListaPalabrasEmocionales() {
        return listaPalabrasEmocionales;
    }

    public void setListaPalabrasEmocionales(List<PalabraEmocional> listaPalabrasEmocionales) {
        this.listaPalabrasEmocionales = listaPalabrasEmocionales;
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

    public void agregarPalabraTecnica(PalabraTecnica palabraTecnica) {
        listaPalabrasTecnicas.add(palabraTecnica);
    }

    public void agregarPalabraEmocional(PalabraEmocional palabraEmocional) {
        listaPalabrasEmocionales.add(palabraEmocional);
    }

}
