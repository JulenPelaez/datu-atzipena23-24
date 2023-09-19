package dambi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenua {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {

            System.out.println("MENDIEN MENUA");
            System.out.println("=================");
            System.out.println("1. Mendien zerrenda ikusi (taula formatuan)");
            System.out.println("2. Mendirik altuena bistaratu");
            System.out.println("3. Mendiak esportatu (Araba.csv, Bizkaia.csv, Gipuzkoa.csv)");
            System.out.println("4. ...");
            System.out.println("5. Irten");
            System.out.print("Aukeratu: ");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la opcion 1");
                    met1();
                    break;
                case 2:
                    System.out.println("Has seleccionado la opcion 2");
                    break;
                case 3:
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

    public static void met1() {
        ArrayList<Mendia> mendiak = new ArrayList<>();
        mendiak = cargarmendiak();
        
        // Imprimir cada objeto Mendia en la lista
        for (Mendia m : mendiak) {
            System.out.println(m);
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

    public static void met2() {

    }
}
