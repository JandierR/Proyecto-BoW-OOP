package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.PalabraEmocional;
import cr.ac.ucenfotec.rojas.jandier.dl.PalabraEmocionalDAO;

import java.util.List;

/**
 * The type Gestor diccionario emocional.
 */
public class GestorDiccionarioEmocional {

//    private Data data;
//
//
//    public GestorDiccionarioEmocional(Data data) {
//        this.data = data;
//    }

    /**
     * Instantiates a new Gestor diccionario emocional.
     */
    public GestorDiccionarioEmocional() {
    }

    /**
     * Obtener palabras emocional list.
     *
     * @return the list
     */
//Tiene que retornar Lista de String o solo String
    public List<PalabraEmocional> obtenerPalabrasEmocional() {
        return PalabraEmocionalDAO.listar();
//        return data.getListaPalabrasEmocionales().toString();
    }

    /**
     * Registrar palabra emocional string.
     *
     * @param palabra the palabra
     * @param emocion the emocion
     * @return the string
     */
    public String registrarPalabraEmocional(String palabra, String emocion) {
//        data.agregarPalabraEmocional(new PalabraEmocional(palabra, emocion));
        PalabraEmocionalDAO.insertar(new PalabraEmocional(palabra, emocion.toLowerCase()));
        return "Palabra emocional registrada exitosamente!";
    }

    /**
     * Eliminar palabra emocional string.
     *
     * @param palabra the palabra
     * @return the string
     */
    public String eliminarPalabraEmocional(String palabra) {
        boolean eliminado = PalabraEmocionalDAO.eliminar(palabra);
        return eliminado ? "Palabra emocional eliminada correctamente" : "No se encontró esa palabra emocional";
    }

    /**
     * Modificar palabra emocional string.
     *
     * @param palabraEmocional the palabra emocional
     * @return the string
     */
    public String modificarPalabraEmocional(PalabraEmocional palabraEmocional) {
        boolean modificado = PalabraEmocionalDAO.modificar(palabraEmocional);
        return modificado ? "Palabra emocional modificada exitosamente" : "No se encontró esa palabra emocional";
    }


}
