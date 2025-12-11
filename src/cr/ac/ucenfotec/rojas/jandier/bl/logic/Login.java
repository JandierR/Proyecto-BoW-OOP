package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;
import cr.ac.ucenfotec.rojas.jandier.dl.Data;

import java.util.Objects;

public class Login {

    private Data data;

    public Login(Data data) {
        this.data = data;
    }

    public boolean iniciaSesion(Usuario usuario, String contrasena, int id) {

        return usuario != null && contrasena.equalsIgnoreCase(usuario.getContrasena()) && id == usuario.getId();
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Login login = (Login) object;
        return Objects.equals(getData(), login.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getData());
    }
}
