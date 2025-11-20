package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;
import cr.ac.ucenfotec.rojas.jandier.dl.Data;

public class Login {

    private Data data;

    public Login(Data data) {
        this.data = data;
    }

    public boolean iniciaSesion(Usuario usuario, String contrasena) {

        return usuario != null && contrasena.equalsIgnoreCase(usuario.getContrasena());
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
