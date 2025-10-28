package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoManager {

    private List<Departamento> listaDepartamento;

    public DepartamentoManager() {

        listaDepartamento = new ArrayList<>();
    }

    public void registrarDepartamento(String nombreDepartamento, String descripcion, String correo) {

        //El nombre del departamento debe de ser unico
        listaDepartamento.add(new Departamento(nombreDepartamento, descripcion, correo));

    }

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public Departamento buscarDepartamentoPorNombre(List<Departamento> listaDepartamento, String nombre) {
        for (Departamento departamento : listaDepartamento) {
            if (departamento.getNombreDepartamento().equalsIgnoreCase(nombre)) {
                return departamento;
            }
        }
        return null;
    }
}
