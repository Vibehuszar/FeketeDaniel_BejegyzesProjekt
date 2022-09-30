import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.System.*;

public class Main {

    public static List<Bejegyzes> bejegyzesek = new ArrayList<>();


    public static void main(String[] args) {
        peldanyok();
        hozzaad();
        bekeres();
        feladat2d();
        feladat2e();
        //feladat2f
        out.println(bejegyzesek);
        feladat3a();
        feladat3b();
        feladat3c();




    }

    public static  void peldanyok(){
        Bejegyzes b1 = new Bejegyzes("Gáspár Laci", "Hegyibeszéd");
        Bejegyzes b2 = new Bejegyzes("Voldemort", "Hókuszpókusz");
        bejegyzesek.add(b1);
        bejegyzesek.add(b2);

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
            Bejegyzes bejegyzes = new Bejegyzes(tomb[0],tomb[1]);
            bejegyzesek.add(bejegyzes);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }

    public  static void feladat2d(){
        Random random = new Random();
        for (int i = 0; i < bejegyzesek.size()*20; i++) {
            bejegyzesek.get(random.nextInt(bejegyzesek.size())).like();
        }
    }

    public static void feladat2e(){
        Scanner sc = new Scanner(System.in);
        out.println("Adja meg a mésodik pélány szövegét");
        String szoveg = sc.next();
        bejegyzesek.get(1).setTartalom(szoveg);

    }

    public static void feladat3a(){
        int max = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > max){
                max = bejegyzesek.get(i).getLikeok();
            }
        }
        out.printf("A legnagyobb likeok száma: %d\n",max);
    }

    public static  void feladat3b(){
        boolean vane = false;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() > 35){
                    vane = true;
                    break;
            }
        }
        if (vane){
            out.println("Van olyan bejegyzés\n");
        }else{
            out.println("Nincs olyan bejegyzés\n");
        }
        }

    public static void feladat3c(){
        boolean vane = false;
        int db = 0;
        for (int i = 0; i < bejegyzesek.size(); i++) {
            if (bejegyzesek.get(i).getLikeok() < 15){
                db++;
            }
        }
        out.println(db + " darab 15-nél kevesebb likeot kapott bejegyzés van\n");
    }

}


