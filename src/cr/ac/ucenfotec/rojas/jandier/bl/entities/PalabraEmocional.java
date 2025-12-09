package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

public class PalabraEmocional extends Palabra {

    private String tipo;

    public PalabraEmocional(String palabra, String tipo) {
        super(palabra);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "PalabraEmocional{" +
                "emocion='" + tipo + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        PalabraEmocional that = (PalabraEmocional) object;
        return Objects.equals(getTipo(), that.getTipo());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getTipo());
        return result;
    }
}
