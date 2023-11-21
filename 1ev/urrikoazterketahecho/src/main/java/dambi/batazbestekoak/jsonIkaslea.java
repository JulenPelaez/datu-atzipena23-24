package dambi.batazbestekoak;

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

public class jsonIkaslea {
    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public jsonIkaslea(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public jsonIkaslea(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public int idatzi(Ikasleak ikasleak) {
        int ikasleKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Ikaslea n : ikasleak.getIkaslea()) {
            jab.add(Json.createObjectBuilder()
                    .add("ikaslea", n.getIkaslea())
                    .add("batazbestekoNota", n.getbatazbestekoNota())
                    .build());
                ikasleKopurua++;
        }
        model=jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }
        return ikasleKopurua;

    }
    public Ikasleak irakurri() {
        Ikasleak notak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            notak = new Ikasleak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Ikaslea nota = new Ikaslea();
                nota.setIkaslea(jsonobj.getString("ikaslea"));

                //Aldagaia batazbestekoNota Double da baina ez dago setDouble funtziorik.
                //nota.setDouble(jsonobj.getString("batazbestekoNota"));
                notak.add(nota);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
        }
        return notak;
    }
}