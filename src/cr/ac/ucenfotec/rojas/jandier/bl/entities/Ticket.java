package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

/**
 * The type Ticket.
 */
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


    /**
     * Instantiates a new Ticket.
     *
     * @param id           the id
     * @param asunto       the asunto
     * @param descripcion  the descripcion
     * @param estado       the estado
     * @param usuario      the usuario
     * @param departamento the departamento
     */
    public Ticket(int id, String asunto, String descripcion, String estado, Usuario usuario, Departamento departamento) {
        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuario = usuario;
        this.departamento = departamento;
    }

    /**
     * Instantiates a new Ticket.
     */
    public Ticket() {

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets asunto.
     *
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * Sets asunto.
     *
     * @param asunto the asunto
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * Gets descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets descripcion.
     *
     * @param descripcion the descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Gets estado.
     *
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets estado.
     *
     * @param estado the estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Gets departamento.
     *
     * @return the departamento
     */
    public Departamento getDepartamento() {
        return departamento;
    }

    /**
     * Sets departamento.
     *
     * @param departamento the departamento
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Gets usuario.
     *
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Sets usuario.
     *
     * @param usuario the usuario
     */
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
