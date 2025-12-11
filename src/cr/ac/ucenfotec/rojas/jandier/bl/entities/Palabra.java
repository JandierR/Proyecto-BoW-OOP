package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

/**
 * The type Palabra.
 */
public class Palabra {

    private String palabra;

    /**
     * Instantiates a new Palabra.
     *
     * @param palabra the palabra
     */
    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * Gets palabra.
     *
     * @return the palabra
     */
    public String getPalabra() {
        return palabra;
    }

    /**
     * Sets palabra.
     *
     * @param palabra the palabra
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        Palabra palabra1 = (Palabra) object;
        return Objects.equals(getPalabra(), palabra1.getPalabra());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getPalabra());
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "palabra='" + palabra + '\'' +
                '}';
    }
}
