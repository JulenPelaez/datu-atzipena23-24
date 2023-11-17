package dambi.mainklaseak;


import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

/**
 * Datu-iturria: Notak.csv
 * Sortutako fitxategia: NotaHobetuak.xml
 * Programa honek nota guztiak puntu bat igoko ditu,
 * kontutan izanik notarik altuena 10 dela.
 * 
 */
public class NotakIgo {
    public static void main(String[] args) {
        Csva csva = new Csva("datuak/Notak.csv");
        Xmla xmla = new Xmla("", "datuak/NotaHobetuak.xml");
        Notak notak = new Notak();
        Notak subidadenota = new Notak();
        notak = csva.irakurri();
        if(notak != null){
            for (Nota recorrido : notak.getNotak()) {
                if ((int) recorrido.getNota() < 10) {
                    recorrido.setNota(recorrido.getNota() + 1);
                }
               subidadenota.add(recorrido);
            }
            System.out.println(xmla.idatzi(subidadenota)+" ikasle idatzi dira csv fitxategian.");
    }
  }
}


