package cr.ac.ucenfotec.rojas.jandier.bl.entities;

public class Usuario {
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String telefono;
    private String rol;

    public Usuario(String nombreCompleto, String correo, String contrasena, String telefono, String rol) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.rol = rol;
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

    @Override
    public String toString() {
        return "-Usuario- -->" +
                "[nombreCompleto = '" + nombreCompleto + '\'' +
                "]--> [correo = '" + correo + '\'' +
                "]--> [contraseña = '" + contrasena + '\'' +
                "]--> [teléfono='" + telefono + '\'' +
                "]--> [rol = '" + rol + '\'' +
                ']';
    }
}
