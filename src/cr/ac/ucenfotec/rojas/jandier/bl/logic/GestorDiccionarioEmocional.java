package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.PalabraEmocional;
import cr.ac.ucenfotec.rojas.jandier.dl.Data;

import java.util.List;
import java.util.Objects;

public class GestorDiccionarioEmocional {

    private Data data;


    public GestorDiccionarioEmocional(Data data) {
        this.data = data;
    }

    public GestorDiccionarioEmocional() {
    }

    //Tiene que retornar Lista de String o solo String
    public List<PalabraEmocional> obtenerPalabrasEmocional() {
        return data.getListaPalabrasEmocionales();
//        return data.getListaPalabrasEmocionales().toString();
    }

    public String registrarPalabraEmocional(String palabra, String emocion) {
        data.agregarPalabraEmocional(new PalabraEmocional(palabra, emocion));
        return "Palabra emocional registrada exitosamente!";
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        GestorDiccionarioEmocional that = (GestorDiccionarioEmocional) object;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}
