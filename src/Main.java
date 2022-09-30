import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.*;

public class Main {

    public static List<Bejegyzes> bejegyzesek = new ArrayList<>();


    public static void main(String[] args) {
        peldanyok();
        bekeres();
        hozzaad();


    }


    public static  void peldanyok(){
        Bejegyzes b1 = new Bejegyzes("Gáspár Laci", "Hegyibeszéd");
        Bejegyzes b2 = new Bejegyzes("Voldemort", "Hókuszpókusz");
        bejegyzesek.add(b1);
        bejegyzesek.add(b2);
    }

    public  static void bekeres(){
        String fajlNev = "bejegyzesek.csv";
        try{
            beolvas(fajlNev);
        }catch (FileNotFoundException e){
            err.println("Hiba");
        }catch (IOException e){
            err.println("Hiba történt");
        }
    }

    public static void beolvas(String fajlNev) throws IOException{
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while (sor != null && sor.equals("")){
            String[] tomb = sor.split(";");
            Bejegyzes bejegyzes = new Bejegyzes(tomb[0], tomb[1]);
            bejegyzesek.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }
    public static void hozzaad(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Adjon meg egy darabszámot: ");
        try {
            int db = sc.nextInt();
            for (int i = 0; i < db; i++) {
                System.out.print("Szerzo: ");
                String szerzo = sc.next();
                System.out.print("Tartalom: ");
                String tartalom = sc.next();
                bejegyzesek.add(new Bejegyzes(szerzo, tartalom));
            }
        }catch (InputMismatchException e){
            err.println("Nem természetes számot adott meg");
        }

    }






}