package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {

    private List<Usuario> listaUsuario;

    public UsuarioManager() {
        listaUsuario = new ArrayList<>();
        //Verificar luego si debo de hacer algun cambio aca en el caso de obtener un bug
    }

    public void registrarUsuario(String nombre, String correo, String contrasena, String telefono, String rol) {
        listaUsuario.add(new Usuario(nombre, correo, contrasena, telefono, rol));

    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public Usuario buscarUsuarioPorCorreo(List<Usuario> listaUsuario, String correo) {
        for (Usuario usuario : listaUsuario) {
            if (usuario.getCorreo().equalsIgnoreCase(correo)) {
                return usuario;
            }
        }
        return null;
    }
}
