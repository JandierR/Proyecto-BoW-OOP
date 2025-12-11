package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;

/**
 * The type Login.
 */
public class Login {

//    private Data data;
//
//    public Login(Data data) {
//        this.data = data;
//    }


    /**
     * Instantiates a new Login.
     */
    public Login() {
    }

    /**
     * Inicia sesion boolean.
     *
     * @param usuario    the usuario
     * @param contrasena the contrasena
     * @param id         the id
     * @return the boolean
     */
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



}
