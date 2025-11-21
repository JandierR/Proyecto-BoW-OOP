package cr.ac.ucenfotec.rojas.jandier.bl.entities;

import java.util.Objects;

public class PalabraTecnica {
    private String palabra;
    private String categoria;

    public PalabraTecnica(String palabra, String categoria) {
        this.palabra = palabra;
        this.categoria = categoria;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
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
                "palabra='" + palabra + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;

        PalabraTecnica that = (PalabraTecnica) object;
        return Objects.equals(getPalabra(), that.getPalabra()) && Objects.equals(getCategoria(), that.getCategoria());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getPalabra());
        result = 31 * result + Objects.hashCode(getCategoria());
        return result;
    }
}
