package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.PalabraEmocional;
import cr.ac.ucenfotec.rojas.jandier.dl.PalabraEmocionalDAO;

import java.util.List;

public class GestorDiccionarioEmocional {

//    private Data data;
//
//
//    public GestorDiccionarioEmocional(Data data) {
//        this.data = data;
//    }

    public GestorDiccionarioEmocional() {
    }

    //Tiene que retornar Lista de String o solo String
    public List<PalabraEmocional> obtenerPalabrasEmocional() {
        return PalabraEmocionalDAO.listar();
//        return data.getListaPalabrasEmocionales().toString();
    }

    public String registrarPalabraEmocional(String palabra, String emocion) {
//        data.agregarPalabraEmocional(new PalabraEmocional(palabra, emocion));
        PalabraEmocionalDAO.insertar(new PalabraEmocional(palabra, emocion.toLowerCase()));
        return "Palabra emocional registrada exitosamente!";
    }

    public String eliminarPalabraEmocional(String palabra) {
        boolean eliminado = PalabraEmocionalDAO.eliminar(palabra);
        return eliminado ? "Palabra emocional eliminada correctamente" : "No se encontró esa palabra emocional";
    }

    public String modificarPalabraEmocional(PalabraEmocional palabraEmocional) {
        boolean modificado = PalabraEmocionalDAO.modificar(palabraEmocional);
        return modificado ? "Palabra emocional modificada exitosamente" : "No se encontró esa palabra emocional";
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
