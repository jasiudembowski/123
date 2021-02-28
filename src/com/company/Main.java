package com.company;
import java.util.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        int pieniadze = 1000;
        int dzien = 1;
        int miesiac = 1;
        int rok = 2020;
        int dzien_kli = 0;
        System.out.println("Twoje podstawowe umiejetności to Java(Backend), Js(Frontend), Bazy Danych, wordpress i prestashop");
        String[] klienci = {"Paweł S.", "Damian K.", "Jerzy P.", "Rafał A.", "Dominika T.", "Kacper B.", "Magdalena B.", "kazimierz W.", "Kordian L.", "Natalia F."};
        start(dzien, miesiac, rok, pieniadze, klienci, dzien_kli);
    }
    public static void start(int dzien, int miesiac, int rok, int pieniadze, String[] klienci, int dzien_kli){
        System.out.println("Twój obecny kapitał wynosi: " + pieniadze);
        if(pieniadze<=0){
            System.out.println("bankructwo");
            System.exit(404);
        }
        System.out.println("Dzisiaj jest " + dzien + "/" + miesiac + "/" + rok);
        System.out.println("Wybierz co chcesz dzisiaj zrobić\n");
        wybor();
        Scanner sc= new Scanner(System.in);
        int wybor = sc.nextInt();

        switch (wybor) {
            case 1 -> umowa_podpis(dzien, miesiac, rok,pieniadze, klienci, dzien_kli);
            case 2 -> klienci(dzien, miesiac, rok,pieniadze,klienci, dzien_kli);
        }

    }
    public static void wybor(){
        System.out.println("1. Podpisz umowę");
        System.out.println("2. Przeznacz dzień na szukanie klientów");
    }
    public static void klienci(int dzien, int miesiac, int rok, int pieniadze, String[] klienci, int dzien_kli){
        dzien_kli = dzien_kli+1;
        if(dzien_kli == 5)
        {
            List<String> arrlist
                    = new ArrayList<String>(
                    Arrays.asList(klienci));
            arrlist.add("Klient nowy");
            klienci = arrlist.toArray(klienci);
            System.out.println(klienci.length);
        }
        dzien = dzien +1;
        start(dzien, miesiac, rok, pieniadze, klienci, dzien_kli);
    }
    public static void umowa_podpis(int dzien, int miesiac, int rok, int pieniadze, String[] klienci, int dzien_kli) {
        String[] technologie = {"Java(Backend)", "Js(Frontend)", "Baza Danych", "Wordpress", "Kotlin(Mobilne)", "Prestashop"};
        System.out.println("Wybierz projekt wpisując 1\n");
        System.out.println("\nUmowa: ");
        Random y=new Random();
        int randomNumber=y.nextInt(technologie.length);
        System.out.println("Twój projekt nazywa sie: abc");
        String[] nazwa_tech = {technologie[randomNumber]};
        System.out.println("Technologia do projektu to: " + nazwa_tech[0]);
        int ilosc_dni = ThreadLocalRandom.current().nextInt(1, 7);
        System.out.println("Ilość dnia roboczych potrzebnych na projekt: " + ilosc_dni);
        Random l= new Random();
        int randomCustomer = l.nextInt(klienci.length);
        String Customer = klienci[randomCustomer];
        System.out.println("Klient to: " + Customer);
        int dzien_oddania = (dzien+7);
        System.out.println("termin oddania to: " + dzien_oddania + "/" + miesiac + "/" + rok );
        int[] termin_oddania = {dzien_oddania,miesiac,rok};
        System.out.println("Kara za przekroczenie terminu: " + 300);
        System.out.println("Cena za realizację: " + 500);
        int gen_platnosci = ThreadLocalRandom.current().nextInt(1, 5);
        int dzien_plat = dzien_oddania  + gen_platnosci;
        System.out.println("Termin płatności: " + dzien_plat + "/" + miesiac + "/" + rok );
        int[] termin_platnosci = {dzien_plat,miesiac,rok};
        System.out.println("Trudność: Proste");

//        System.out.println("\nDruga umowa: ");
//        Random x=new Random();
//        int randomNumber_2=x.nextInt(technologie.length);
//        System.out.println("Twój projekt nazywa sie: abc");
//        System.out.println("Technologia do projektu to: " + technologie[randomNumber_2]);
//        int ilosc_dni_2 = ThreadLocalRandom.current().nextInt(1, 14);
//        System.out.println("Ilość dnia roboczych potrzebnych na projekt: " + ilosc_dni);
//        System.out.println("Klient to: abc");
//        int dzien_oddania_2 = (dzien+14);
//        System.out.println("termin oddania to: " + dzien_oddania + "/" + miesiac + "/" + rok );
//        System.out.println("Kara za przekroczenie terminu: " + 600);
//        System.out.println("Cena za realizację: " + 1000);
//        int termin_platnosci_2 = ThreadLocalRandom.current().nextInt(1, 5);
//        int dzien_plat_2 = dzien_oddania  + gen_platnosci;
//        System.out.println("Termin płatności: " + dzien_plat + "/" + miesiac + "/" + rok );
        Scanner sc= new Scanner(System.in);
        int wybor = sc.nextInt();

        if(wybor == 1){
            if(nazwa_tech[0].equals("Kotlin(Mobilne)"))
            {
                System.out.println("Nie masz posiadanych umiejetności, czy chcesz oddac projekt komuś innemu ?[Tak/Nie]");
                String wybor_1 = sc.nextLine();
                if(wybor_1.equals("Tak"))
                {
                    Scanner scu= new Scanner(System.in);
                    System.out.println("Wybierz komu chcesz oddac projekt wybierajac od 1-3");
                    System.out.println("najlepszy uczeń - najdroższy, ale robi na czas i bez błędów. - koszt 300");
                    System.out.println("średni uczeń - robi na czas, ale jest 10% ryzyka, że trzeba będzie po nim poprawiać. - koszt 200");
                    System.out.println("koleś, który wie wszystko najlepiej - najtańszy, 20% ryzyka że się spóźni i 20% ryzyka że będzie trzeba po nim poprawiać. - koszt 100");

                    int wybor_czl = scu.nextInt();
                    if(wybor_czl==1){
                        int procent_pop = 0;
                        int procent_sp = 0;
                        po_umowie_czlo(dzien, miesiac, rok, nazwa_tech, ilosc_dni, termin_oddania, 300, 500, termin_platnosci, Customer, pieniadze-300, klienci, dzien_kli,procent_pop, procent_sp);
                    } else if(wybor_czl==2){
                        int procent_pop = 10;
                        int procent_sp = 0;
                        po_umowie_czlo(dzien, miesiac, rok, nazwa_tech, ilosc_dni, termin_oddania, 300, 500, termin_platnosci, Customer, pieniadze-300, klienci, dzien_kli,procent_pop, procent_sp);

                    }else if(wybor_czl==3){
                        int procent_pop = 20;
                        int procent_sp = 20;
                        po_umowie_czlo(dzien, miesiac, rok, nazwa_tech, ilosc_dni, termin_oddania, 300, 500, termin_platnosci, Customer, pieniadze-300, klienci, dzien_kli,procent_pop, procent_sp);
                    }
                }
                else if(wybor_1.equals("Nie"))
                {
                    dzien = dzien+1;
                    start(dzien, miesiac, rok, pieniadze, klienci, dzien_kli);
                }
            }
            else {
                dzien = dzien+1;
                po_umowie(dzien, miesiac, rok, nazwa_tech, ilosc_dni, termin_oddania, 300, 500, termin_platnosci, Customer, pieniadze, klienci, dzien_kli);
            }
        }
        else if(wybor == 2){

        }
        else{
            System.out.println("Brak takiej opcji, proszę wybrać prawidłową");
        }
    }
    public static void po_umowie(int dzien, int miesiac, int rok, String[] technologie, int ilosc_dni, int[] termin_odd, int kara, int wyplata, int[] dzien_plat, String klient, int pieniadze, String[] klienci, int dzien_kli){
        System.out.println("Dzisiaj jest " + dzien + "/" + miesiac + "/" + rok);
        System.out.println("Zostało ci: " + (termin_odd[0]-dzien) + " dni na oddanie projektu");
        if(ilosc_dni==0){
            System.out.println("Możesz oddać projekt");
        }
        if(ilosc_dni <0) {
            System.out.println("Spóźnienie. Została nałożona kara.");
            pieniadze = pieniadze-kara;
            dzien = dzien+1;
            start(dzien, miesiac, rok, pieniadze, klienci, dzien_kli);
        }
        System.out.println("Wybierz co chcesz dzisiaj zrobić\n");
        wybor_po();
        Scanner sc= new Scanner(System.in);
        int wybor = sc.nextInt();

        switch (wybor) {
            case 1 -> klienci_2(dzien, miesiac, rok, technologie, ilosc_dni, termin_odd, 300, 500, dzien_plat, klient, pieniadze, klienci, dzien_kli);
            case 2 -> programowanie(dzien, miesiac, rok, technologie, ilosc_dni, termin_odd, 300, 500, dzien_plat, klient, pieniadze, klienci, dzien_kli);
            case 3 -> oddaj_projekt(dzien, miesiac, rok, technologie, ilosc_dni, termin_odd, 300, 500, dzien_plat, klient, pieniadze, klienci, dzien_kli);
        }
    }
    public static void wybor_po(){
        System.out.println("1. Przeznacz dzień na szukanie klientów");
        System.out.println("2. Przeznacz dzień na programowanie");
        System.out.println("3. Oddaj projekt");
    }
    public static void klienci_2(int dzien, int miesiac, int rok, String[] technologie, int ilosc_dni, int[] termin_odd, int kara, int wyplata, int[] dzien_plat, String klient, int pieniadze, String[] klienci, int dzien_kli){
        dzien_kli = dzien_kli+1;
        if(dzien_kli == 5)
        {
            List<String> arrlist
                    = new ArrayList<String>(
                    Arrays.asList(klienci));
            arrlist.add("Klient nowy");
            klienci = arrlist.toArray(klienci);
            System.out.println(klienci.length);
        }
        dzien = dzien +1;
        ilosc_dni = ilosc_dni - 1;
        po_umowie(dzien, miesiac, rok, technologie, ilosc_dni, termin_odd, 300, 500, dzien_plat, klient, pieniadze, klienci, dzien_kli);
    }
    public static void programowanie(int dzien, int miesiac, int rok, String[] technologie, int ilosc_dni, int[] termin_odd, int kara, int wyplata, int[] dzien_plat, String klient, int pieniadze, String[] klienci, int dzien_kli){
        dzien = dzien +1;
        ilosc_dni = ilosc_dni - 1;
        po_umowie(dzien, miesiac, rok, technologie, ilosc_dni, termin_odd, 300, 500, dzien_plat, klient, pieniadze, klienci, dzien_kli);
    }
    public static void oddaj_projekt(int dzien, int miesiac, int rok, String[] technologie, int ilosc_dni, int[] termin_odd, int kara, int wyplata, int[] dzien_plat, String klient, int pieniadze, String[] klienci, int dzien_kli){
        if(ilosc_dni==0){
            pieniadze = pieniadze+wyplata;
            dzien = dzien+1;
            start(dzien, miesiac, rok, pieniadze, klienci, dzien_kli);
        }
        else if(ilosc_dni>0){
            System.out.println("Za szybko");
            po_umowie(dzien, miesiac, rok, technologie, ilosc_dni, termin_odd, 300, 500, dzien_plat, klient, pieniadze, klienci, dzien_kli);
        }

    }
    public static void po_umowie_czlo(int dzien, int miesiac, int rok, String[] technologie, int ilosc_dni, int[] termin_odd, int kara, int wyplata, int[] dzien_plat, String klient, int pieniadze, String[] klienci, int dzien_kli, int procent_poprawienia, int procent_spoznienia) {
        if(ilosc_dni==0 && procent_poprawienia==0 && procent_spoznienia==0){
            System.out.println("Można oddać projekt");
        }
        else if(ilosc_dni==0 && procent_poprawienia==10 && procent_spoznienia==0){
            double rand = ThreadLocalRandom.current().nextDouble(1, 10);
            if(rand<=1){
                System.out.println("System wymaga poprawek");
            }
        }else if(ilosc_dni==0 && procent_poprawienia==20 && procent_spoznienia==20){
            double rand = ThreadLocalRandom.current().nextDouble(1, 10);
            if(rand<=2){
                System.out.println("Spóznienie");
                ilosc_dni = ilosc_dni + ThreadLocalRandom.current().nextInt(1, 2);
            }
        }
        System.out.println("Dzisiaj jest " + dzien + "/" + miesiac + "/" + rok);
        System.out.println("Zostało ci: " + (termin_odd[0] - dzien) + " dni na oddanie projektu");
        if (ilosc_dni == 0) {
            System.out.println("Możesz oddać projekt");
        }
        if (ilosc_dni < 0) {
            System.out.println("Spóźnienie. Została nałożona kara.");
            pieniadze = pieniadze - kara;
            dzien = dzien + 1;
            start(dzien, miesiac, rok, pieniadze, klienci, dzien_kli);
        }
        System.out.println("Wybierz co chcesz dzisiaj zrobić\n");
        wybor_po();
        Scanner sc = new Scanner(System.in);
        int wybor = sc.nextInt();
        ilosc_dni = ilosc_dni - 1;
        switch (wybor) {
            case 1 -> klienci_2(dzien, miesiac, rok, technologie, ilosc_dni, termin_odd, 300, 500, dzien_plat, klient, pieniadze, klienci, dzien_kli);
            case 2 -> oddaj_projekt(dzien, miesiac, rok, technologie, ilosc_dni, termin_odd, 300, 500, dzien_plat, klient, pieniadze, klienci, dzien_kli);
        }
    }

}
