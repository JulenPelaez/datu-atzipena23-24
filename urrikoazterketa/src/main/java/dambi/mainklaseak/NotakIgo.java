package dambi.mainklaseak;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class NotakIgo {
    public static void main(String[] args) {
        Csva csva = new Csva("data/Notak.csv");
        Xmla xmla = new Xmla("", "data/NotaHobetuak.xml");
        Notak notak = new Notak();
        Notak notaBerriak = new Notak();
        notak = csva.irakurri();
        if(notak != null){
            for (Nota m : notak.getNotak()) {
                if ((int) m.getNota() < 10) {
                    m.setNota(m.getNota() + 1);
                    notaBerriak.add(m);
                }
            }
            System.out.println(xmla.idatzi(notaBerriak)+" ikasle idatzi dira csv fitxategian.");

    }

}
}




    
