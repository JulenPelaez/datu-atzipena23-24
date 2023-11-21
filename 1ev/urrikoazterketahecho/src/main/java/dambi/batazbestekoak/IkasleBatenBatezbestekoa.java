package dambi.batazbestekoak;
import java.util.Scanner;

import dambi.atzipenekoak.Csva;
import dambi.pojoak.Nota;
import dambi.pojoak.Notak;

public class IkasleBatenBatezbestekoa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Sar ezazu ikaslearen izena: ");
        String izena = in.next();
        in.close();
        float ikaslearenBatazbestekoa = aurkituIkaslea(izena);
        if(ikaslearenBatazbestekoa == -1){
            System.out.println("Ez da existitzen " + izena + " izena duen ikaslerik.");
        }
        else{
            System.out.println(izena + " ikaslearen batazbesteko nota " + ikaslearenBatazbestekoa + " da.");
        }
    }
    public static float aurkituIkaslea(String izena){
        Csva csva = new Csva("data/Notak.csv");
        Notak notak = new Notak();
        notak = csva.irakurri();
        float batazbestekoa = 0;
        float batuketa = 0;
        int kont = 0;
        if(notak != null){
            for (Nota m : notak.getNotak()) {
                if (m.getIkaslea().equals(izena)) {
                    batuketa = batuketa + (float)m.getNota();
                    kont++;
                }
            }
        }
        if(kont != 0){
            batazbestekoa = batuketa / kont;
        }
        else{
            batazbestekoa = -1;
        }
        return batazbestekoa;
    }
}
