package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

public class PalabraEmocional extends Palabra {

    private String emocion;

    public PalabraEmocional(String palabra, String emocion) {
        super(palabra);
        this.emocion = emocion;
    }

    public String getEmocion() {
        return emocion;
    }

    public void setEmocion(String emocion) {
        this.emocion = emocion;
    }

    @Override
    public String toString() {
        return "PalabraEmocional{" +
                "emocion='" + emocion + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        PalabraEmocional that = (PalabraEmocional) object;
        return Objects.equals(getEmocion(), that.getEmocion());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getEmocion());
        return result;
    }
}
