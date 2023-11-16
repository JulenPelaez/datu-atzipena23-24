package dambi.batazbestekoak;


import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Ikasleak")
public class Ikasleak {

    List<Ikaslea> ikaslea;
public List<Ikaslea> getIkaslea() {
        return ikaslea;
    }

    @XmlElement(name = "Ikaslea")
    public void setNotak(List<Ikaslea> ikaslea) {
        this.ikaslea = ikaslea;
    }

    public void add(Ikaslea ikaslea) {
        if (this.ikaslea == null) {
            this.ikaslea = new ArrayList<Ikaslea>();
        }
        this.ikaslea.add(ikaslea);

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Ikaslea n : this.ikaslea) {
            str.append(n.toString());
            str.append("\n");
        }
        return str.toString();
    }
}