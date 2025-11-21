package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;
import cr.ac.ucenfotec.rojas.jandier.dl.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestorDepartamento {
    private Data data;
//    private List<Departamento> listaDepartamento;

    public GestorDepartamento(Data data) {

//        listaDepartamento = new ArrayList<>();
        this.data = data;

    }

    public List<String> obtenerDepartamentos() {

        List<String> resultado = new ArrayList<>();
        if (data.getListaDepartamento().isEmpty()) {
            resultado.add("[Lista vacía]");
            return resultado;
        }
        //En este caso que no este vacia la lista, se imprime sus elementos.
        for (Departamento departamento : data.getListaDepartamento()) {
            resultado.add(departamento.toString());
        }
        return resultado;
    }

    //Este metodo registrarDepartamento se utiliza en la UI, en otro metodo llamado registrarDepartamento.
    //El mismo permite agregar a listaDepartamento el nuevo departamento registrado desde Controller de la UI.
    public String registrarDepartamento(String nombreDepartamento, String descripcion, String correo, int id) {

        boolean existeDepartamento = existeDepartamento(data.getListaDepartamento(), id);

        if (existeDepartamento) {
            return "Lo sentimos, ya existe este departamento";
        }

        data.agregarDepartamento(new Departamento(nombreDepartamento, descripcion, correo, id));
        return "Departamento registrado exitosamente";

    }




    //Este metodo verifica si existe algun departamento de la listaDepartamento con el ID que se pasa como parametro (argumento en ejecucion)
    public boolean existeDepartamento(List<Departamento> listaDepartamento, int id) {
        for (Departamento departamento : listaDepartamento) {
            //Si existe el departamento, retorna verdadero
            if (departamento.getId() == id) {
                return true;
            }
        }
        //Si no existe, retorna falso
        return false;
    }

    //Este metodo busca en la listaDepartamento el departamento con el ID ingresado.
    public Departamento buscarPorId(List<Departamento> listaDepartamento, int id) {
        for (Departamento departamento : listaDepartamento) {
            //Si hay un departamento con ese ID, se retorna el departamento
            if (departamento.getId() == id) {
                return departamento;
            }
        }
        //En el caso de que no haya match de id, entonces no existe el departamento, por lo que se retorna null.
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        GestorDepartamento that = (GestorDepartamento) object;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}
