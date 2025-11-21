package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

public class PalabraEmocional {

    private String palabra;
    private String emocion;

    public PalabraEmocional(String palabra, String emocion) {
        this.palabra = palabra;
        this.emocion = emocion;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
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
                "palabra='" + palabra + '\'' +
                ", emocion='" + emocion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        PalabraEmocional that = (PalabraEmocional) object;
        return Objects.equals(getPalabra(), that.getPalabra()) && Objects.equals(getEmocion(), that.getEmocion());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getPalabra());
        result = 31 * result + Objects.hashCode(getEmocion());
        return result;
    }
}
