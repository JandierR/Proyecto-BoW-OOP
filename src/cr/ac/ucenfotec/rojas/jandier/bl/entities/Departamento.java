package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

public class Departamento {

    //El nombre del departamento debe de ser unico.
    private String nombreDepartamento;
    private String descripcion;
    private String correo;
    private int id;


    //En la logica, debe de haber una relacion en la que cada departamento puede
    //Tener muchos tickets.


    public Departamento(String nombreDepartamento, String descripcion, String correo, int id) {
        this.nombreDepartamento = nombreDepartamento;
        this.descripcion = descripcion;
        this.correo = correo;
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

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
