package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuario {

    private List<Usuario> listaUsuario;

    public GestorUsuario() {
        listaUsuario = new ArrayList<>();
        //Verificar luego si debo de hacer algun cambio aca en el caso de obtener un bug
    }

    public void registrarUsuario(String nombre, String correo, String contrasena, String telefono, String rol, int id) {
        listaUsuario.add(new Usuario(nombre, correo, contrasena, telefono, rol, id));

    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    //Retornar un booleano
    public boolean existeUsuario(List<Usuario> listaUsuario, int id) {
        for (Usuario usuario : listaUsuario) {
            if (usuario.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //Este metodo no se puede utilizar en el UI. Sin embargo, si se puede utilizar en el ticketManager
    public Usuario buscarPorId(List<Usuario> listaUsuario, int id) {
        for (Usuario usuario : listaUsuario) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }
}
