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

    //Este metodo registra los usuarios con base a sus atributos ingresados como parametros (argumentos en ejecuicion)
    public void registrarUsuario(String nombre, String correo, String contrasena, String telefono, String rol, int id) {
        listaUsuario.add(new Usuario(nombre, correo, contrasena, telefono, rol, id));

    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    //Este metodo verifica si existe un usuario en la listaUsuario con el ID pasado como argumento
    public boolean existeUsuario(List<Usuario> listaUsuario, int id) {
        for (Usuario usuario : listaUsuario) {
            //Si el usuario existe, se retorna verdadero
            if (usuario.getId() == id) {
                return true;
            }
        }
        //Si el usuario no existe, se retorna falso
        return false;
    }

    //Este metodo no se puede utilizar en el UI. Sin embargo, si se puede utilizar en el ticketManager
    //Este metodo busca en la listaUsuario un usuario con el id ingresado como argumento
    public Usuario buscarPorId(List<Usuario> listaUsuario, int id) {
        for (Usuario usuario : listaUsuario) {
            //Si hay un usuario con el id pasado, entonces si existe y se retorna el usuario
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        //Si no, se retorna null, porque no existe
        return null;
    }
}
