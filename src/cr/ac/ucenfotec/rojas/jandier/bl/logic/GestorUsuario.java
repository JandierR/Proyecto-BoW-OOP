package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Usuario;
import cr.ac.ucenfotec.rojas.jandier.dl.UsuarioDAO;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuario {

//    private Data data;
//
//    public GestorUsuario(Data data) {
//        this.data = data;
//    }

    public GestorUsuario() {
    }

    public List<String> obtenerUsuarios() {

        List<Usuario> usuarios = UsuarioDAO.listar();
        List<String> resultado = new ArrayList<>();

        if (usuarios.isEmpty()) {
            resultado.add("[Lista vacía]");
            return resultado;
        }
        //En este caso que no este vacia la lista, se imprime sus elementos.
        for (Usuario usuario : usuarios) {
            resultado.add(usuario.toString());
        }
        return resultado;

    }

    //Este metodo registra los usuarios con base a sus atributos ingresados como parametros (argumentos en ejecuicion)
    public String registrarUsuario(String nombre, String correo, String contrasena, String telefono, String rol, int id) {

        boolean existeUsuario = existeUsuario( id);

        if (existeUsuario) {
            return "Lo sentimos, ya existe este usuario";
        }

//        data.agregarUsuario(new Usuario(nombre, correo, contrasena, telefono, rol, id));
        UsuarioDAO.insertar(new Usuario(nombre, correo, contrasena, telefono, rol, id));
        return "Usuario registrado exitosamente!";
    }


    //Este metodo verifica si existe un usuario en la listaUsuario con el ID pasado como argumento
    public boolean existeUsuario( int id) {
        List<Usuario> usuarios = UsuarioDAO.listar();
        for (Usuario usuario : usuarios) {
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
    public Usuario buscarPorId(int id) {
        List<Usuario> usuarios = UsuarioDAO.listar();
        for (Usuario usuario : usuarios) {
            //Si hay un usuario con el id pasado, entonces si existe y se retorna el usuario
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        //Si no, se retorna null, porque no existe
        return null;
    }

    public String eliminarUsuario(int id) {
        boolean eliminado = UsuarioDAO.eliminar(id);
        return eliminado ? "Usuario eliminado correctamente" : "No se encontro ese usuario";
    }

    public String modificarUsuario(Usuario usuario) {
        boolean modificado = UsuarioDAO.modificar(usuario);
        return modificado ? "Usuario modificado exitosamente" : "No se encontro ese usuario";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
