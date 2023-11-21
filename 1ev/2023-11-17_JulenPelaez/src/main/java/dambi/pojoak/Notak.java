package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import dambi.atzipenekoak.Csva;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Notak")
public class Notak {

    List<Nota> notak;

    public List<Nota> getNotak() {
        return notak;
    }
    
    @XmlElement(name = "Nota")
    public void setNotak(List<Nota> notak) {
        this.notak = notak;
    }

    public void add(Nota nota) {
        if (this.notak == null) {
            this.notak = new ArrayList<Nota>();
        }
        this.notak.add(nota);

    }

    /**
     * Hau da erabili dezakezun algoritmoetako bat:
     * Zera errepikatu noten zerrenda hutsik egon arte:
     * - Noten zerrendako "lehen" ikaslea hartu, bere datuak hasieratuz (batura, kontadorea)
     *   eta zerrenda errebisatu atzenerarte bere noten bila. 
     * - Bere nota bat aurkitutakoan batu, zenbatu eta aurkitutako nota ezabatu egingo dugu traba egin ez dezan
     * - Azken notara heltzerakoan, ikasleen zerrendan gehitu eta berriz hasi.
     * 
     */
    public Ikasleak getIkasleenBB() {
        Csva csva = new Csva("data/Notak.csv");
        Notak notak = new Notak();
        ArrayList <String> kalkulatutakoIkasleak = new ArrayList <String>();
        Ikasleak ikasleak = new Ikasleak();
        Boolean encontrado = false;
        Double batazbestekoa = 0.0;
        Double suma = 0.0;
        int kontaketa = 0;
        notak = csva.irakurri();
        String izena;
        for(int i =0;i<notak.getNotak().size(); i++){
            izena = notak.getNotak().get(i).getIkaslea();
            for(int j =0;j<kalkulatutakoIkasleak.size(); j++){
                if(kalkulatutakoIkasleak.get(j).equals(izena)){
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                kalkulatutakoIkasleak.add(izena);
                for (Nota m : notak.getNotak()) {
                    if (m.getIkaslea().equals(izena)) {
                        suma = suma + (float)m.getNota();
                        kontaketa++;
                    }
                }
                if(kontaketa != 0){
                    batazbestekoa = suma / kontaketa;
                    ikasleak.add(new Ikaslea(izena, batazbestekoa));
                }
            }
        }
                
        //METODO HAU OSATU
        
        return ikasleak;
    }

    /**
     * Ikasle baten nota guztien batezbestekoa kalkulatzen du.
     * 
     * @param ikaslea Adibidez, madariaga.idoia
     * @return Ikaslea motako objektu bat, atributo bezala batezbestekoa kalkulatuta
     *         daukana.
     */
    public Ikaslea getIkaslearenBB(String strIkaslea) {
        int guztira = 0;// ikasleari dagozkion noten batura joango gara gehitzen hemen
        int notaKopurua = 0;// ikasle honi dagazkion nota kopurua joango gara kontatzen hemen
        for (Nota n : notak) {
            if (n.getIkaslea().equals(strIkaslea)) {
                guztira += n.getNota();
                notaKopurua++;
            }
        }
        return new Ikaslea(strIkaslea, guztira / notaKopurua);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Nota n : this.notak) {
            str.append(n.toString());
            str.append("\n");
        }
        return str.toString();
    }

}
