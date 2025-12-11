package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.Departamento;
import cr.ac.ucenfotec.rojas.jandier.dl.DepartamentoDAO;

import java.util.ArrayList;
import java.util.List;

public class GestorDepartamento {

    public GestorDepartamento() {
    }



    public List<String> obtenerDepartamentos() {

        List<String> resultado = new ArrayList<>();
        List<Departamento> departamentos = DepartamentoDAO.listar();
        if (departamentos.isEmpty()) {
            resultado.add("[Lista vacía]");
            return resultado;
        }
        //En este caso que no este vacia la lista, se imprime sus elementos.
        for (Departamento departamento : departamentos) {
            resultado.add(departamento.toString());
        }
        return resultado;
    }

    //Este metodo registrarDepartamento se utiliza en la UI, en otro metodo llamado registrarDepartamento.
    //El mismo permite agregar a listaDepartamento el nuevo departamento registrado desde Controller de la UI.
    public String registrarDepartamento(String nombreDepartamento, String descripcion, String correo, int id) {

        boolean existeDepartamento = existeDepartamento(id);

        if (existeDepartamento) {
            return "Lo sentimos, ya existe este departamento";
        }

//        data.agregarDepartamento(new Departamento(nombreDepartamento, descripcion, correo, id));
        DepartamentoDAO.insertar(new Departamento(nombreDepartamento, descripcion, correo, id));
        return "Departamento registrado exitosamente";

    }




    //Este metodo verifica si existe algun departamento de la listaDepartamento con el ID que se pasa como parametro (argumento en ejecucion)
    public boolean existeDepartamento( int id) {
        List<Departamento> departamentos = DepartamentoDAO.listar();
        for (Departamento departamento : departamentos) {
            //Si existe el departamento, retorna verdadero
            if (departamento.getId() == id) {
                return true;
            }
        }
        //Si no existe, retorna falso
        return false;
    }

    //Este metodo busca en la listaDepartamento el departamento con el ID ingresado.
    public Departamento buscarPorId(int id) {
        List<Departamento> departamentos = DepartamentoDAO.listar();

        for (Departamento departamento : departamentos) {
            //Si hay un departamento con ese ID, se retorna el departamento
            if (departamento.getId() == id) {
                return departamento;
            }
        }
        //En el caso de que no haya match de id, entonces no existe el departamento, por lo que se retorna null.
        return null;
    }

    public String eliminarDepartamento(int id) {
        boolean eliminado = DepartamentoDAO.eliminar(id);
        return eliminado ? "Departamento eliminado correctamente" : "No se encontro ese departamento";
    }

    public String modificarDepartamento(Departamento departamento) {
        boolean modificado = DepartamentoDAO.modificar(departamento);
        return modificado ? "Departamento modificado exitosamente" : "No se encontro ese departamento";
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
