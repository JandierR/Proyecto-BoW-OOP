package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;

import java.util.ArrayList;
import java.util.List;

public class GestorDepartamento {

    private List<Departamento> listaDepartamento;

    public GestorDepartamento() {

        listaDepartamento = new ArrayList<>();
    }

    //Este metodo registrarDepartamento se utiliza en la UI, en otro metodo llamado registrarDepartamento.
    //El mismo permite agregar a listaDepartamento el nuevo departamento registrado desde Controller de la UI.
    public void registrarDepartamento(String nombreDepartamento, String descripcion, String correo, int id) {

        //El nombre del departamento debe de ser unico
        listaDepartamento.add(new Departamento(nombreDepartamento, descripcion, correo, id));

    }

    //Este metodo de getListaDepartamento es la que se encarga de retornar la listaDepartamento...
    //en el metodo de la UI, imprimirDepartamento, la cual llama a este metodo y se utiliza para listar departamento.
    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
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
}
