package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class Jsona {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public Jsona(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public Jsona(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    /** Osatu ezazu metodo hau
    *
    */	 
    public Notak irakurri() {
        Notak notak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            notak = new Notak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Nota nota = new Nota();
                nota.setId(jsonobj.getInt("id"));
                nota.setIkaslea(jsonobj.getString("ikaslea"));
                nota.setData(jsonobj.getString("data"));
                nota.setIkasgaia(jsonobj.getString("ikasgaia"));
                nota.setNota(jsonobj.getInt("nota"));
                notak.add(nota);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
        }
        return notak;
    }

    public int idatzi(Notak notak) {
        int notaKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Nota n : notak.getNotak()) {
            jab.add(Json.createObjectBuilder()
                    .add("id", n.getId())
                    .add("ikaslea", n.getIkaslea())
                    .add("data", n.getData())
                    .add("ikasgaia", n.getIkasgaia())
                    .add("nota",n.getNota())
                    .build());
            notaKopurua++;
        }
        model=jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }
        return notaKopurua;

    }
}
