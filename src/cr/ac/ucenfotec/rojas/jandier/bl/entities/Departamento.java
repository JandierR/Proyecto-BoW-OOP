package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

/**
 * The type Departamento.
 */
public class Departamento {

    //El nombre del departamento debe de ser unico.
    private String nombreDepartamento;
    private String descripcion;
    private String correo;
    private int id;


    //En la logica, debe de haber una relacion en la que cada departamento puede
    //Tener muchos tickets.


    /**
     * Instantiates a new Departamento.
     *
     * @param nombreDepartamento the nombre departamento
     * @param descripcion        the descripcion
     * @param correo             the correo
     * @param id                 the id
     */
    public Departamento(String nombreDepartamento, String descripcion, String correo, int id) {
        this.nombreDepartamento = nombreDepartamento;
        this.descripcion = descripcion;
        this.correo = correo;
        this.id = id;
    }

    /**
     * Gets nombre departamento.
     *
     * @return the nombre departamento
     */
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    /**
     * Sets nombre departamento.
     *
     * @param nombreDepartamento the nombre departamento
     */
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    /**
     * Gets correo.
     *
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Sets correo.
     *
     * @param correo the correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
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

    @Override
    public String toString() {
        return "-Departamento- --> " +
                "[nombreDepartamento = '" + nombreDepartamento + '\'' +
                "]--> [descripción = '" + descripcion + '\'' +
                "]--> [correo = '" + correo + '\'' +
                "]--> [ID = '#" + id + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Departamento that = (Departamento) object;
        return getId() == that.getId() && Objects.equals(getNombreDepartamento(), that.getNombreDepartamento()) && Objects.equals(getDescripcion(), that.getDescripcion()) && Objects.equals(getCorreo(), that.getCorreo());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getNombreDepartamento());
        result = 31 * result + Objects.hashCode(getDescripcion());
        result = 31 * result + Objects.hashCode(getCorreo());
        result = 31 * result + getId();
        return result;
    }
}
