// Przelewy miedzy kontami V
// Przelew BLIK V
// Kantor
// Kredyt
// Pozyczka
// Debet
// limit odnawialny
// Konto oszczednosciowe
// Logi transakcji na każdym koncie
// Mozliwość działania apliakcji w czasie rzeczywistym i menu wyboru operacji

public class Main {
    public static void main(String[] args){

        Konto pawlak = new Konto("Kamil","123",500);
        Konto juzek = new Konto("juzek","345",500);

        pawlak.stanKonta();
        pawlak.wplacPieniadze(100);
        pawlak.wyplacPieniadze(50);
        pawlak.stanKonta();
        pawlak.wyplacPieniadze(100);
        pawlak.stanKonta();
        System.out.println("NOWE PRZELEW --------------------");
        Przelew nowyPrzelew = new Przelew(pawlak,juzek,200);
        nowyPrzelew.wyslaniePrzelewu();
        System.out.println("BLIK -----------------------------");
        Blik operacjaBlik = new Blik(pawlak,juzek,100);
        pawlak.blik = operacjaBlik.generowanieKoduBlik();
        operacjaBlik.przelewBlik(pawlak.blik);
        System.out.println("KANTOR -----------------------------");
        Kantor kantorPawlak = pawlak.otworzKantor();
        kantorPawlak.operacjaZmianyWaluty(100,"EUR","USD");
        kantorPawlak.operacjaZmianyWaluty(50,"RUB","RUB");
        kantorPawlak.operacjaZmianyWaluty(50,"RUB","EUR");
        for(float waluta:kantorPawlak.stanKontaKantorowego){
            System.out.println(waluta);
        }

    }
}