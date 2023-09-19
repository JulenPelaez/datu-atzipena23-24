package dambi;

public class Mendia {
    String izena;
    int altuera;
    String probintzia;

    public Mendia(String izena, int altuera, String probintzia) {
        this.izena = izena;
        this.altuera = altuera;
        this.probintzia = probintzia;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public int getAltuera() {
        return altuera;
    }

    public void setAltuera(int altuera) {
        this.altuera = altuera;
    }

    public String getProbintzia() {
        return probintzia;
    }

    public void setProbintzia(String probintzia) {
        this.probintzia = probintzia;
    }

    @Override
    public String toString() {
        return izena + " " + altuera + " " + probintzia +"\n";
    }
    

}
