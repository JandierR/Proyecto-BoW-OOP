package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;

import java.util.ArrayList;
import java.util.List;

public class GestorDepartamento {

    private List<Departamento> listaDepartamento;

    public GestorDepartamento() {

        listaDepartamento = new ArrayList<>();
    }

    public void registrarDepartamento(String nombreDepartamento, String descripcion, String correo, int id) {

        //El nombre del departamento debe de ser unico
        listaDepartamento.add(new Departamento(nombreDepartamento, descripcion, correo, id));

    }

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public boolean existeDepartamento(List<Departamento> listaDepartamento, int id) {
        for (Departamento departamento : listaDepartamento) {
            if (departamento.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public Departamento buscarPorId(List<Departamento> listaDepartamento, int id) {
        for (Departamento departamento : listaDepartamento) {
            if (departamento.getId() == id) {
                return departamento;
            }
        }
        return null;
    }
}
