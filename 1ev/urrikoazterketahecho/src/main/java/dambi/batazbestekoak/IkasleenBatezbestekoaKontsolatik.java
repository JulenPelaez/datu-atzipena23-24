package dambi.batazbestekoak;
import java.util.ArrayList;

import dambi.atzipenekoak.Csva;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;
public class IkasleenBatezbestekoaKontsolatik {
    public static void main(String[] args) {
        Csva csva = new Csva("data/Notak.csv");
        Notak notak = new Notak();
        ArrayList <String> kalkulatutakoIkasleak = new ArrayList <String>();

        Ikasleak ikasleak = new Ikasleak();

        Boolean aurkituta = false;
        Double batazbeste = 0.0;
        Double batuketa = 0.0;
        int kont = 0;
        notak = csva.irakurri();
        String izena;
        for(int i =0;i<notak.getNotak().size(); i++){
            izena = notak.getNotak().get(i).getIkaslea();
            for(int j =0;j<kalkulatutakoIkasleak.size(); j++){
                if(kalkulatutakoIkasleak.get(j).equals(izena)){
                    aurkituta = true;
                    break;
                }
            }
            if(!aurkituta){
                kalkulatutakoIkasleak.add(izena);
                for (Nota m : notak.getNotak()) {
                    if (m.getIkaslea().equals(izena)) {
                        batuketa = batuketa + (float)m.getNota();
                        kont++;
                    }
                }
                if(kont != 0){
                    batazbeste = batuketa / kont;
                    ikasleak.add(new Ikaslea(izena, batazbeste));
                }
            }
        }
        
        System.out.println("IKASLEA\t\t\t\t BATEZBESTEKOA");
        System.out.println("====================================================================");
        for(int z = 0; z < ikasleak.getIkaslea().size(); z++){
            System.out.println(ikasleak.getIkaslea().get(z).getIkaslea() + "\t\t\t\t\t " + ikasleak.getIkaslea().get(z).getbatazbestekoNota());
        }
    }
}