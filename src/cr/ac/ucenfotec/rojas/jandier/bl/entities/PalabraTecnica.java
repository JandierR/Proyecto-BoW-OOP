package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

/**
 * The type Palabra tecnica.
 */
public class PalabraTecnica extends Palabra {
    private String categoria;

    /**
     * Instantiates a new Palabra tecnica.
     *
     * @param palabra   the palabra
     * @param categoria the categoria
     */
    public PalabraTecnica(String palabra, String categoria) {
        super(palabra);
        this.categoria = categoria;
    }

    /**
     * Gets categoria.
     *
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Sets categoria.
     *
     * @param categoria the categoria
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "PalabraTecnica{" +
                "categoria='" + categoria + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        PalabraTecnica that = (PalabraTecnica) object;
        return Objects.equals(getCategoria(), that.getCategoria());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(getCategoria());
        return result;
    }
}
