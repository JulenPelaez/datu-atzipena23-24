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
import javax.json.JsonValue;
import javax.json.JsonWriter;

import dambi.pojoak.Ikaslea;
import dambi.pojoak.Ikasleak;
import dambi.pojoak.Notak;


public class JsonIkasleak {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public JsonIkasleak(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public JsonIkasleak(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public int idatzi(Ikasleak ikasleak) {
        int ikasleKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Ikaslea n : ikasleak.getIkasleak()) {
            jab.add(Json.createObjectBuilder()
                    .add("ikaslea", n.getIkaslea())
                    .add("batezbestekoa", n.getBatezbestekoa())
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
    /**
     * ADI: Notak objetu bat jasotzen du metodo honek
     * @param notak
     * @return
     */
    public int idatzi(Notak notak) {
            int ikasleKopurua = 0;
            JsonArray model = null;
            JsonArrayBuilder jab = Json.createArrayBuilder();
            Ikasleak ikasleak = new Ikasleak();

            for (Ikaslea n : ikasleak.getIkasleak()) {
                
                jab.add(Json.createObjectBuilder()
                        .add("ikaslea", n.getIkaslea())
                        .add("batazbestekoNota", (JsonValue) notak.getIkaslearenBB(strFileIn))
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
}
