package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

public class PalabraTecnica extends Palabra {
    private String categoria;

    public PalabraTecnica(String palabra, String categoria) {
        super(palabra);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

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
