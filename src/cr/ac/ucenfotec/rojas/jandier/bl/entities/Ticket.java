package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

public class Ticket {
    //El id presenta que el ticket sea unico
    private int id;
    private String asunto;
    private String descripcion;
    private String estado;
    private Usuario usuario;
    private Departamento departamento;

    //El ticket se debe de asociar con un solo usuario.
    //Tambien se debe de asociar con un solo departamento.


    public Ticket(int id, String asunto, String descripcion, String estado, Usuario usuario, Departamento departamento) {
        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuario = usuario;
        this.departamento = departamento;
    }

    public Ticket() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "-Ticket- -->" +
                "[id = " + id +
                "]--> [asunto = '" + asunto + '\'' +
                "]--> [descripción = '" + descripcion + '\'' +
                "]--> [estado = '" + estado + '\'' +
                "]--> [usuario = " + usuario.toString() +
                "]--> [departamento = " + departamento.toString() +
                ']';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Ticket ticket = (Ticket) object;
        return getId() == ticket.getId() && Objects.equals(getAsunto(), ticket.getAsunto()) && Objects.equals(getDescripcion(), ticket.getDescripcion()) && Objects.equals(getEstado(), ticket.getEstado()) && Objects.equals(getUsuario(), ticket.getUsuario()) && Objects.equals(getDepartamento(), ticket.getDepartamento());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + Objects.hashCode(getAsunto());
        result = 31 * result + Objects.hashCode(getDescripcion());
        result = 31 * result + Objects.hashCode(getEstado());
        result = 31 * result + Objects.hashCode(getUsuario());
        result = 31 * result + Objects.hashCode(getDepartamento());
        return result;
    }
}
