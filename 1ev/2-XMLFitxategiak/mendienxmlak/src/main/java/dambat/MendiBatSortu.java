package dambat;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

@XmlType(propOrder = { "izena", "altuera", "probintzia" })
@XmlRootElement(name = "Mendibat")
public class MendiBatSortu {
    private String izena;
    private double altuera;
    private String probintzia;

    public MendiBatSortu() {
    }

    public MendiBatSortu(String izena, double altuera, String probintzia) {
        this.izena = izena;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    @XmlElement
    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    @XmlElement
    public double getAltuera() {
        return altuera;
    }

    public void setAltuera(double altuera) {
        this.altuera = altuera;
    }

    @XmlElement
    public String getProbintzia() {
        return probintzia;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    public static void main(String[] args) {
        MendiBatSortu monte = new MendiBatSortu("Monte A", 2000.0, "Gipuzkoa");

        try {
            JAXBContext context = JAXBContext.newInstance(MendiBatSortu.class);

            Marshaller marshaller = context.createMarshaller();
            File xmlFile = new File("mendibat.xml");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(monte, xmlFile); 

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
