package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.PalabraTecnica;
import cr.ac.ucenfotec.rojas.jandier.dl.Data;

import java.util.List;

public class GestorDiccionarioTecnico {

    private Data data;

    public GestorDiccionarioTecnico(Data data) {
        this.data = data;
    }

    public GestorDiccionarioTecnico() {
    }

    //Tiene que retornar Lista de String o solo String
    public List<PalabraTecnica> obtenerPalabrasTecnicas() {
        return data.getListaPalabrasTecnicas();
//        return data.getPalabrasTecnicas().toString();
    }

    public String registrarPalabraTecnica(String palabra, String categoria) {
        data.agregarPalabraTecnica(new PalabraTecnica(palabra, categoria));
        return "Palabra técnica registrada exitosamente";
    }
}
