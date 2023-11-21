package dambi;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) throws IOException {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("MENDIEN MENUA");
            System.out.println("=================");
            System.out.println("1. Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2. Mendirik altuena bistaratu");
            System.out.println("3. Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv, Nafarroa.csv)");
            System.out.println("4. ...");
            System.out.println("5. Irten");
            System.out.print("Aukeratu: ");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    zerrendaikusi();
                    break;
                case 2:
                    mendialtuena();
                    break;
                case 3:
                    mendiakesportatu();
                    System.out.println("Has seleccionado la opcion 3");
                    break;
                case 4:
                    System.out.println("si");
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");
            }
        }
    }

    public static void zerrendaikusi() {
        ArrayList<Mendia> mendiak = new ArrayList<>();
        mendiak = cargarmendiak();

        // Imprimir cada objeto Mendia en la lista
        for (Mendia m : mendiak) {
            System.out.println(m);
        }
    }

    /**
     * Metodo honek....
     * 
     */
    public static void mendialtuena() {
        ArrayList<Mendia> mendiak = new ArrayList<>();
        mendiak = cargarmendiak();
        int n = 0, a;
        for (Mendia m : mendiak) {
            a = m.getAltuera();
            if (a > n) {
                n = a;
            }
        }
        for (Mendia j : mendiak) {
            a = j.getAltuera();
            if (a == n) {
                System.out.println(j);
            }

        }
    }

    public static void mendiakesportatu() throws IOException {
        ArrayList<Mendia> mendiak = cargarmendiak();

        FileOutputStream outGipuzkoa = new FileOutputStream("Gipuzkoa.csv");
        FileOutputStream outBizkaia = new FileOutputStream("Bizkaia.csv");
        FileOutputStream outAraba = new FileOutputStream("Araba.csv");
        FileOutputStream outNafarroa = new FileOutputStream("Nafarroa.csv");

        for (Mendia m : mendiak) {
            if (m.getProbintzia().equals("Gipuzkoa")) {
                String linea = m.getIzena() + ";" + m.getAltuera() + ";" + m.getProbintzia() + "\n";
                outGipuzkoa.write(linea.getBytes());
            }
            if (m.getProbintzia().equals("Bizkaia")) {
                String linea = m.getIzena() + ";" + m.getAltuera() + ";" + m.getProbintzia() + "\n";
                outBizkaia.write(linea.getBytes());
            }
            if (m.getProbintzia().equals("Araba")) {
                String linea = m.getIzena() + ";" + m.getAltuera() + ";" + m.getProbintzia() + "\n";
                outAraba.write(linea.getBytes());
            }
            if (m.getProbintzia().equals("Nafarroa")) {
                String linea = m.getIzena() + ";" + m.getAltuera() + ";" + m.getProbintzia() + "\n";
                outNafarroa.write(linea.getBytes());
            }
        }
    }

    public static ArrayList<Mendia> cargarmendiak() {
        ArrayList<Mendia> mendiak = new ArrayList<>();
        try {
            FileReader in = new FileReader("Mendiak.csv");
            BufferedReader reader = new BufferedReader(in);

            reader.readLine();

            String linea = "";
            while ((linea = reader.readLine()) != null) {
                // linea: "Aketegi;1548;Gipuzkoa"
                String[] parts = linea.split(";");
                String nombre = parts[0];
                int altura = Integer.parseInt(parts[1]);
                String probintzia = parts[2];
                Mendia m = new Mendia(nombre, altura, probintzia);
                mendiak.add(m);
            }
        } catch (Exception exception) {
            System.out.println("ez dut aurkitu");
        }
        return mendiak;

    }

}