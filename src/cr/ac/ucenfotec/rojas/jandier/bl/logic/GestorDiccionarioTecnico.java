package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.PalabraTecnica;
import cr.ac.ucenfotec.rojas.jandier.dl.PalabraTecnicaDAO;

import java.util.List;

public class GestorDiccionarioTecnico {


    public GestorDiccionarioTecnico() {
    }

    //Tiene que retornar Lista de String o solo String
    public List<PalabraTecnica> obtenerPalabrasTecnicas() {
        return PalabraTecnicaDAO.listar();
//        return data.getPalabrasTecnicas().toString();
    }

    public String registrarPalabraTecnica(String palabra, String categoria) {
//        data.agregarPalabraTecnica(new PalabraTecnica(palabra, categoria));
        PalabraTecnicaDAO.insertar(new PalabraTecnica(palabra, categoria.toLowerCase()));
        return "Palabra técnica registrada exitosamente";
    }

    public String eliminarPalabraTecnica(String palabra) {
        boolean eliminado = PalabraTecnicaDAO.eliminar(palabra);
        return eliminado ? "Palabra técnica eliminada correctamente" : "No se encontró esa palabra técnica";
    }

    public String modificarPalabraTecnica(PalabraTecnica palabraTecnica) {
        boolean modificado = PalabraTecnicaDAO.modificar(palabraTecnica);
        return modificado ? "Palabra técnica modificada exitosamente" : "No se encontró esa palabra técnica";
    }


}

