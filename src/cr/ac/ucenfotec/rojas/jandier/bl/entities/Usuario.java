package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

public class Usuario {
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String telefono;
    private String rol;
    private int id;

    public Usuario(String nombreCompleto, String correo, String contrasena, String telefono, String rol, int id) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.rol = rol;
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "-Usuario- -->" +
                "[nombreCompleto = '" + nombreCompleto + '\'' +
                "]--> [correo = '" + correo + '\'' +
                "]--> [contraseña = '" + contrasena + '\'' +
                "]--> [teléfono='" + telefono + '\'' +
                "]--> [rol = '" + rol + '\'' +
                "]--> [ID = '#" + id + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Usuario usuario = (Usuario) object;
        return getId() == usuario.getId() && Objects.equals(getNombreCompleto(), usuario.getNombreCompleto()) && Objects.equals(getCorreo(), usuario.getCorreo()) && Objects.equals(getContrasena(), usuario.getContrasena()) && Objects.equals(getTelefono(), usuario.getTelefono()) && Objects.equals(getRol(), usuario.getRol());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getNombreCompleto());
        result = 31 * result + Objects.hashCode(getCorreo());
        result = 31 * result + Objects.hashCode(getContrasena());
        result = 31 * result + Objects.hashCode(getTelefono());
        result = 31 * result + Objects.hashCode(getRol());
        result = 31 * result + getId();
        return result;
    }
}
