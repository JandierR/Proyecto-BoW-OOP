package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

/**
 * The type Usuario.
 */
public class Usuario {
    private String nombreCompleto;
    private String correo;
    private String contrasena;
    private String telefono;
    private String rol;
    private int id;

    /**
     * Instantiates a new Usuario.
     *
     * @param nombreCompleto the nombre completo
     * @param correo         the correo
     * @param contrasena     the contrasena
     * @param telefono       the telefono
     * @param rol            the rol
     * @param id             the id
     */
    public Usuario(String nombreCompleto, String correo, String contrasena, String telefono, String rol, int id) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.rol = rol;
        this.id = id;
    }

    /**
     * Gets nombre completo.
     *
     * @return the nombre completo
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Sets nombre completo.
     *
     * @param nombreCompleto the nombre completo
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
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
     * Gets telefono.
     *
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sets telefono.
     *
     * @param telefono the telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Gets contrasena.
     *
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Sets contrasena.
     *
     * @param contrasena the contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Gets rol.
     *
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * Sets rol.
     *
     * @param rol the rol
     */
    public void setRol(String rol) {
        this.rol = rol;
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
