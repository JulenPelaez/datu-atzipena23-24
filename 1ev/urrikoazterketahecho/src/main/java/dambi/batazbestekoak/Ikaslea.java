package dambi.batazbestekoak;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "ikaslea" , "batazbestekoNota"})
@XmlRootElement(name = "Ikaslea")
public class Ikaslea {
    int id = 0;
    String ikaslea;
    Double batazbestekoNota;
    public Ikaslea(String izena, Double balioa){
        this.ikaslea = izena;
        this.batazbestekoNota = balioa;
    }
    public Ikaslea(){

    }
    public String getIkaslea() {
        return ikaslea;
    }

    @XmlElement(name = "Ikaslea")
    public void setIkaslea(String ikaslea) {
        this.ikaslea = ikaslea;
    }
    public Double getbatazbestekoNota(){
        return batazbestekoNota;
     }
 
     @XmlElement(name = "batazbestekoNota")
     public void setbatazbestekoNota(Double batazbestekoNota) {
         this.batazbestekoNota = batazbestekoNota;
     }

    @Override
    public String toString() {
        return "Ikaslea[" +ikaslea+ "," + batazbestekoNota + "]";
    }
}