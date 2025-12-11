package cr.ac.ucenfotec.rojas.jandier.bl.logic;

import cr.ac.ucenfotec.rojas.jandier.bl.entities.PalabraEmocional;
import cr.ac.ucenfotec.rojas.jandier.bl.entities.PalabraTecnica;
import cr.ac.ucenfotec.rojas.jandier.dl.PalabraEmocionalDAO;
import cr.ac.ucenfotec.rojas.jandier.dl.PalabraTecnicaDAO;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class AnalisisBoW {

//    private Data data;

    //    public static void main(String[] args) {
//        String descripcion = "Me siento feliz, porque voy a terminar el curso";
//        eliminarStopWords(descripcion);
//        normalizacion(descripcion);
//        String[] nuevaDescripcion = tokenizacion(descripcion);
//
//        for (String p : nuevaDescripcion) {
//            System.out.print(p + " ");
//        }
//
//    }
//    public AnalisisBoW(Data data) {
//        this.data = data;
//    }

    public AnalisisBoW() {
    }

    public String eliminarStopWords(String descripcion) {


        String[] stopWords = {"a", "al", "algo", "algunas", "algunos", "ante", "antes", "como", "con",
                "contra", "cual", "cuales", "cuando", "de", "del", "desde", "donde",
                "durante", "e", "el", "él", "ella", "ellas", "ellos", "en", "entre",
                "era", "erais", "eran", "eras", "es", "esa", "esas", "ese", "eso",
                "esos", "esta", "estaba", "estabais", "estaban", "estabas", "estad",
                "estamos", "están", "estar", "estará", "estas", "este", "esto", "estos",
                "fue", "fueron", "fui", "ha", "habéis", "habían", "habías", "han",
                "has", "hasta", "hay", "la", "las", "le", "les", "lo", "los", "me",
                "mi", "mis", "mucho", "muy", "nada", "ni", "no", "nos", "nosotras",
                "nosotros", "o", "os", "otra", "otras", "otro", "otros", "para",
                "pero", "poco", "por", "porque", "que", "quien", "quienes", "se",
                "sera", "será", "si", "sí", "siempre", "sin", "sobre", "sois",
                "somos", "son", "su", "sus", "tal", "también", "tampoco", "te", "ti",
                "tiene", "tienen", "todo", "todos", "tu", "tus", "un", "una", "unas",
                "uno", "unos", "vosotras", "vosotros", "y", "ya", "voy"};

        String descripcionTmp = normalizacion(descripcion);

        String[] tokens = descripcionTmp.split(" ");

        StringBuilder resultado = new StringBuilder();

        //Se recorre tokens
        for (String palabra : tokens) {
            boolean esStopWord = false;

            for (String stop : stopWords) {
                if (palabra.equalsIgnoreCase(stop)) {
                    esStopWord = true;
                    break;
                }
            }
            if (!esStopWord) {
                resultado.append(palabra).append(" ");
            }
        }

        return resultado.toString().trim();
    }

    public String normalizacion(String descripcion) {

        if (descripcion == null) {
            return "Error. Sin descripción!";

        }

        //El metodo toLowerCase permite pasar todo a minusculas.
        String descripcionTemporal = descripcion.toLowerCase();

        //El normalizer me permite descomponer los caracteres como tildes y separarlos como texto normal en el String
        descripcionTemporal = Normalizer.normalize(descripcionTemporal, Normalizer.Form.NFD);

        //Este replaceAll me permite eliminar todos esos caracteres que sobran a "", o sea, nada.
        descripcionTemporal = descripcionTemporal.replaceAll("\\p{M}", "");

        //Esto me permite reemplazar todos los caracteres que no sea una letra de la "a" hasta "z" por espacio en blanco " ".
        descripcionTemporal = descripcionTemporal.replaceAll("[^a-z\\s]", " ");

        //Aqui se permite eliminar reducir todo espacio en blanco repetido a un solo espacio en blanco.
        descripcionTemporal = descripcionTemporal.replaceAll("\\s+", " ");

        //El metodo trim permite que se eliminen espacio al inicio y final
        descripcionTemporal = descripcionTemporal.trim();

        return descripcionTemporal;
    }

    public String[] tokenizacion(String descripcion) {
        descripcion = eliminarStopWords(descripcion);

        return descripcion.split(" ");
    }


    public String detectarEstadoAnimo(String descripcion) {

        if (descripcion == null) {
            return "Error";
        }

        //Aqui se limpia la descripcion
        String descripcionLimpia = eliminarStopWords(descripcion);
        descripcionLimpia = normalizacion(descripcionLimpia);
        String[] tokens = tokenizacion(descripcionLimpia);

        int positivo = 0;
        int negativo = 0;
        int neutral = 0;

        List<String> palabrasDetonantes = new ArrayList<>();
        List<PalabraEmocional> palabrasEmocionales = PalabraEmocionalDAO.listar();
        for (String token : tokens) {
            for (PalabraEmocional palabraEmocional : palabrasEmocionales) {

                if (palabrasEmocionales.isEmpty()) {
                    return "Lo sentimos. No has registrado palabras para el análisis!";
                }

                if (token.equalsIgnoreCase(palabraEmocional.getPalabra())) {
                    palabrasDetonantes.add(token);
                    switch (palabraEmocional.getTipo().toLowerCase()) {
                        case "positivo" -> positivo++;
                        case "negativo" -> negativo++;
                        case "neutral" -> neutral++;

                    }
                }
            }
        }

        if (positivo == 0 && negativo == 0 && neutral == 0) {
            return "No identificado";
        } else if (positivo > negativo && positivo > neutral) {
            return "POSITIVO ---> Palabras detonantes = " + palabrasDetonantes;
        } else if (negativo > positivo && negativo > neutral) {
            return "NEGATIVO ---> Palabras detonantes = " + palabrasDetonantes;
        } else if (neutral > negativo && neutral > positivo) {
            return "NEUTRAL ---> Palabras detonantes = " + palabrasDetonantes;
        }
        return "No identificado";
    }

    public List<String> detectarCategoriaTecnica(String descripcion) {


        List<String> categorias = new ArrayList<>();
        List<PalabraTecnica> palabrasTecnicas = PalabraTecnicaDAO.listar();

        //Aqui se limpia la descripcion
        String descripcionLimpia = eliminarStopWords(descripcion);
        descripcionLimpia = normalizacion(descripcionLimpia);
        String[] tokens = tokenizacion(descripcionLimpia);

        for (String token : tokens) {
            for (PalabraTecnica palabraTecnica : palabrasTecnicas) {
                if (token.equalsIgnoreCase(palabraTecnica.getPalabra())) {
                    if (!categorias.contains(palabraTecnica.getCategoria())) {
                        categorias.add(palabraTecnica.getCategoria().toUpperCase() + " --> Palabra detonante = " + token);
                    }
                }
            }
        }

        return categorias;
    }



}
