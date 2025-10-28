package cr.ac.ucenfotec.rojas.jandier.bl.entities;

public class Departamento {

    //El nombre del departamento debe de ser unico.
    private String nombreDepartamento;
    private String descripcion;
    private String correo;

    //En la logica, debe de haber una relacion en la que cada departamento puede
    //Tener muchos tickets.


    public Departamento(String nombreDepartamento, String descripcion, String correo) {
        this.nombreDepartamento = nombreDepartamento;
        this.descripcion = descripcion;
        this.correo = correo;
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

    @Override
    public String toString() {
        return "-Departamento- --> " +
                "[nombreDepartamento = '" + nombreDepartamento + '\'' +
                "]--> [descripción = '" + descripcion + '\'' +
                "]--> [correo = '" + correo + '\'' +
                ']';
    }
}
