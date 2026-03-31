// Przelewy miedzy kontami V
// Przelew BLIK V
// Kantor V
// Kredyt V
// Pozyczka
// Debet
// limit odnawialny
// Konto oszczednosciowe
// Logi transakcji na każdym koncie !!!
// Mozliwość działania apliakcji w czasie rzeczywistym i menu wyboru operacji

import java.util.Optional;
import java.util.*;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        ArrayList<Konto> konta = new ArrayList<>();
        boolean zalogowany = false;
        Konto aktualneKonto = null;
        float kwotaPrzelewu;
        int kwotaWplaty;
        String kontoDoPrzelewu;
        Kantor aktualnyKantor = null;
        boolean czyKantorUtworzony=false;

        while(true){
            if(zalogowany){
                System.out.println("1 - Zamknij konto");
                System.out.println("2 - Wyloguj sie z konta");
                System.out.println("3 - Wykonaj przelew");
                System.out.println("4 - Wykonaj BLIK");
                System.out.println("5 - Otworz Kantor");
                System.out.println("6 - Sprawdz logi");
                System.out.println("7 - Sprawdz stan konta");
                System.out.println("8 - Wplac pieniadze");
                System.out.println("9 - Wyplac pieniadze");
                System.out.println("10 - Wymień pieniadzę");
                System.out.println("11 - Sprawdz stan kantoru");
                System.out.println("12 - Koniec programu");
            } else {
                System.out.println("1 - Otworz konto");
                System.out.println("2 - Zaloguj sie do konta");
                System.out.println("12 - Koniec programu");
            }

            int wybor = scanner.nextInt();

            switch(wybor){
                case 1: // TWORZENIE KONTA // USUWANIE KONTA ///////////////////////////////////////////////////////////////////////////////////
                    scanner.nextLine();
                    System.out.println("Wprowadz nazwe konta :");
                    String nazwaKonta = scanner.nextLine();
                    System.out.println("Wprowadz haslo: ");
                    String hasloUzytkownika = scanner.nextLine();
                    System.out.println("Wprowadz kwote poczatkowa:");
                    int kwotaPoczatkowa = scanner.nextInt();

                    Konto noweKonto = new Konto(nazwaKonta,hasloUzytkownika,kwotaPoczatkowa);
                    konta.add(noweKonto);

                    for(Konto k :konta){
                        System.out.println(k.nazwaUzytkownika);
                    }
                    break;

                case 2: // LOGOWANIE DO KONTA // WYLOGOWANIE Z KONTA ///////////////////////////////////////////////////////////////////////////////////
                    scanner.nextLine();

                    if(zalogowany){
                        zalogowany = false;
                        break;
                    }else{
                        System.out.println("wprowadz nazwe konta:");
                        String nazwa = scanner.nextLine();
                        for(Konto k:konta){
                            if(nazwa.equals(k.nazwaUzytkownika)){

                                System.out.println("Wprowadz haslo:");
                                String haslo = scanner.nextLine();

                                if(haslo.equals(k.hasloUzytkownika)){
                                    zalogowany = true;
                                    aktualneKonto = k;
                                    break;
                                }else{
                                    System.out.println("Bledne haslo");

                                    break;
                                }
                            }else{
                                System.out.println("Bledny login lub brak takiego konta");
                                scanner.nextLine();
                                break;
                            }
                        }
                    }
                    break;

                case 3: // WYKONANIE PRZELEWU ///////////////////////////////////////////////////////////////////////////////////
                    scanner.nextLine();
                    System.out.println("Wprowadz kwote przelewu:");
                    kwotaPrzelewu = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Wprowadz nazwe konta na ktore zostanie wyslany przelew:");
                    kontoDoPrzelewu = scanner.nextLine();

                    for (Konto doceloweKonto : konta){
                        if(doceloweKonto.nazwaUzytkownika.equals(kontoDoPrzelewu)){
                            Przelew nowyPrzelew = new Przelew(aktualneKonto,doceloweKonto,kwotaPrzelewu);
                            nowyPrzelew.wyslaniePrzelewu();
                        }
                    }

                    break;
                case 4: // BLIK ///////////////////////////////////////////////////////////////////////////////////
                    scanner.nextLine();
                    System.out.println("Wprowadz kwote przelewu:");
                    kwotaPrzelewu = scanner.nextFloat();

                    scanner.nextLine();
                    System.out.println("Wprowadz nazwe konta na ktore zostanie wyslany przelew:");
                    kontoDoPrzelewu = scanner.nextLine();

                    int kodBlik;

                    for(Konto doceloweKonto: konta){
                        if(doceloweKonto.nazwaUzytkownika.equals(kontoDoPrzelewu)){
                            Blik operacjaBlik = new Blik(aktualneKonto,doceloweKonto,kwotaPrzelewu);
                            System.out.println("Wprowadz kod BLIK:");
                            kodBlik = scanner.nextInt();
                            operacjaBlik.przelewBlik(kodBlik);
                        }
                    }
                    break;
                case 5:
                    assert aktualneKonto != null;
                    Kantor nowyKantor = aktualneKonto.otworzKantor();
                    aktualnyKantor = nowyKantor;
                    czyKantorUtworzony=true;
                    aktualnyKantor.stanKontaKantorowego[3] = aktualneKonto.stanKonta;

                    break;
                case 6:
                    assert aktualneKonto != null;
                    for(Log log: aktualneKonto.wezLogi()){
                        System.out.println(log);
                    }
                    break;
                case 7:
                    assert aktualneKonto != null;
                    System.out.println(aktualneKonto.stanKonta());
                    break;
                case 8:
                    System.out.println("Wprowadz ile chcesz wplacic");
                    kwotaWplaty = scanner.nextInt();
                    assert aktualneKonto != null;
                    aktualneKonto.wplacPieniadze(kwotaWplaty);
                    break;
                case 9:
                    System.out.println("Wprowadz ile chcesz wyplacic:");
                    kwotaWplaty = scanner.nextInt();
                    assert aktualneKonto != null;
                    aktualneKonto.wyplacPieniadze(kwotaWplaty);
                    break;
                case 10:
                    scanner.nextLine();
                    System.out.println("Wprowadz walute jaką zamieniasz:");
                    String walutaWej = scanner.nextLine();
                    System.out.println("Wprowadz walute jaką kupujesz:");
                    String walutaWyj = scanner.nextLine();
                    System.out.println("Wprowadz kwote jaką zamieniasz:");
                    float kwota = scanner.nextFloat();
                    assert aktualnyKantor != null;
                    aktualnyKantor.operacjaZmianyWaluty(aktualneKonto,walutaWej,walutaWyj,kwota);

                    aktualneKonto.stanKonta-=kwota;

                    break;
                case 11:
                    assert aktualnyKantor != null;
                    System.out.println("USD: "+aktualnyKantor.stanKontaKantorowego[0]);
                    System.out.println("RUB: "+aktualnyKantor.stanKontaKantorowego[1]);
                    System.out.println("EUR: "+aktualnyKantor.stanKontaKantorowego[2]);
                    System.out.println("PLN: "+aktualnyKantor.stanKontaKantorowego[3]);
                    break;
                case 12: // ZAMKNIECIE PROGRAMU ///////////////////////////////////////////////////////////////////////////////////
                    scanner.close();
                    return;
            }

        }

//        Konto jeden = new Konto("1","111",100);
//        Konto dwa = new Konto("2","222",100);
//        Konto trzy = new Konto("3","333",100);
//
//        Konto pawlak = new Konto("Kamil","123",500);
//        Konto juzek = new Konto("juzek","345",500);

//        pawlak.stanKonta();
//        pawlak.wplacPieniadze(100);
//        pawlak.wyplacPieniadze(50);
//        pawlak.stanKonta();
//        pawlak.wyplacPieniadze(100);
//        pawlak.stanKonta();

//        System.out.println("NOWE PRZELEW --------------------");
//
//        Przelew nowyPrzelew = new Przelew(pawlak,juzek,200);
//        nowyPrzelew.wyslaniePrzelewu();
//        Przelew nowy2Przelew = new Przelew(juzek,pawlak,200);
//        nowy2Przelew.wyslaniePrzelewu();


//        System.out.println("BLIK -----------------------------");
//        Blik operacjaBlik = new Blik(pawlak,juzek,100);
//        pawlak.blik = operacjaBlik.generowanieKoduBlik();
//        operacjaBlik.przelewBlik(pawlak.blik);

//        System.out.println("KANTOR -----------------------------");
//        Kantor kantorPawlak = pawlak.otworzKantor();
//        Kantor kantorJuzek = juzek.otworzKantor();
//
//        kantorPawlak.operacjaZmianyWaluty(kantorPawlak.stanKontaKantorowego,"EUR","USD",100);
//        kantorPawlak.operacjaZmianyWaluty(kantorPawlak.stanKontaKantorowego,"EUR","EUR",100);
//        kantorPawlak.operacjaZmianyWaluty(kantorPawlak.stanKontaKantorowego,"EUR","RUB",100);
//
//        System.out.println("+++++++++++++++++++++");
//
//        kantorJuzek.operacjaZmianyWaluty(kantorJuzek.stanKontaKantorowego,"USD","RUB",100);
//        kantorJuzek.operacjaZmianyWaluty(kantorJuzek.stanKontaKantorowego,"USD","RUB",300);
//        kantorJuzek.operacjaZmianyWaluty(kantorJuzek.stanKontaKantorowego,"RUB","RUB",100);
//
//        for(float waluta:kantorPawlak.stanKontaKantorowego){
//            System.out.println(waluta);
//        }
//        System.out.println("++++++++++++++++++");
//        for(float waluta:kantorJuzek.stanKontaKantorowego){
//            System.out.println(waluta);
//        }
//
//        System.out.println("KREDYT =====================");
//
//        pawlak.wezKredyt(1000,0.6f,0.02f).ifPresent(k -> {
//            k.naliczenieOdsetek();
//            k.naliczenieOdsetek();
//            k.naliczenieOdsetek();
//            k.splataRaty(100);
//        });
//
//        for(Log log: juzek.wezLogi()){
//            System.out.println(log);
//        }
//
//        for(Log log: pawlak.wezLogi()){
//            System.out.println(log);
//        }
    }
}