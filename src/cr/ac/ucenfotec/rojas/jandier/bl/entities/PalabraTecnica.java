package cr.ac.ucenfotec.rojas.jandier.bl.entities;

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
}
