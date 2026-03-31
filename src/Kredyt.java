// dodac sprawdzenie zdolnosci kredytowej
// dodac dodac sporzadzenie umowy // taka po chuju oczywiscie

public class Kredyt {
    Konto uzytkownik;
    float wartoscKredytu;
    float okresSplaty;
    float oprocentowanie;
    float wartoscDoSplaty;
    float odsetki;

    //odsetki = kapitał * oprocentowanie * czas

    public void naliczenieOdsetek(){
        int idOperacji = 6;
        Awarie awaria = new Awarie(idOperacji);

        if(awaria.wystapienieAwarii(idOperacji)){
            uzytkownik.dodajLog(new Log(uzytkownik.id,0,idOperacji,"FAILED",idOperacji));
        }else{
            odsetki = wartoscKredytu * oprocentowanie * okresSplaty;
            wartoscDoSplaty += odsetki;

            System.out.println("Odsetki: " + odsetki);
            System.out.println("KwotaKoncowa: " + wartoscDoSplaty);

            uzytkownik.dodajLog(new Log(uzytkownik.id,odsetki,idOperacji,"Naliczono odsetki",idOperacji));
        }
    }

    public void splataRaty(float kwotaSplaty){
        int idOperacji = 5;
        Awarie awaria = new Awarie(idOperacji);

        if(awaria.wystapienieAwarii(idOperacji)){
            uzytkownik.dodajLog(new Log(uzytkownik.id,0,idOperacji,"FAILED",idOperacji));
        }else{
            wartoscDoSplaty -= kwotaSplaty;
            System.out.println("wartosc po splacie: " + wartoscDoSplaty);
            uzytkownik.dodajLog(new Log(uzytkownik.id,wartoscDoSplaty,idOperacji,"Splacono rate",idOperacji));
        }

    }

    public Kredyt(Konto uzytkownik,float  wartoscKredytu, float okresSplaty,float oprocentowanie){
        this.uzytkownik = uzytkownik;
        this.wartoscKredytu = wartoscKredytu;
        this.okresSplaty = okresSplaty;
        this.oprocentowanie = oprocentowanie;
        wartoscDoSplaty = wartoscKredytu;
        System.out.println("WZIALES KREDYT");
    }
}
