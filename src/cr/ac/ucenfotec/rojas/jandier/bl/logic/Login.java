package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;

public class Login {

//    private Data data;
//
//    public Login(Data data) {
//        this.data = data;
//    }


    public Login() {
    }

    public boolean iniciaSesion(Usuario usuario, String contrasena, int id) {

        return usuario != null && contrasena.equalsIgnoreCase(usuario.getContrasena()) && id == usuario.getId();
    }

//    public Data getData() {
//        return data;
//    }
//
//    public void setData(Data data) {
//        this.data = data;
//    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
