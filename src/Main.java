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

public class Main {
    public static void main(String[] args){

        Konto pawlak = new Konto("Kamil","123",500);
        Konto juzek = new Konto("juzek","345",500);

//        pawlak.stanKonta();
//        pawlak.wplacPieniadze(100);
//        pawlak.wyplacPieniadze(50);
//        pawlak.stanKonta();
//        pawlak.wyplacPieniadze(100);
//        pawlak.stanKonta();
        System.out.println("NOWE PRZELEW --------------------");
        Przelew nowyPrzelew = new Przelew(pawlak,juzek,200);
        nowyPrzelew.wyslaniePrzelewu();
        for(Log log: pawlak.wezLogi()){
            System.out.println(log);
        }
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
//        Kredyt kredytPawlaka = pawlak.wezKredyt(1000,0.6f,0.02f);
//        kredytPawlaka.naliczenieOdsetek();
//        kredytPawlaka.naliczenieOdsetek();
//        kredytPawlaka.naliczenieOdsetek();
//        kredytPawlaka.splataRaty(100);

    }
}