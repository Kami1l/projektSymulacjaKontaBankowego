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
        odsetki = wartoscKredytu * oprocentowanie * okresSplaty;
        wartoscDoSplaty += odsetki;

        System.out.println("Odsetki: " + odsetki);
        System.out.println("KwotaKoncowa: " + wartoscDoSplaty);

    }

    public void splataRaty(float kwotaSplaty){
        wartoscDoSplaty -= kwotaSplaty;
        System.out.println("wartosc po splacie: " + wartoscDoSplaty);
    }

    public Kredyt(Konto uzytkownik,float  wartoscKredytu, float okresSplaty,float oprocentowanie){
        this.uzytkownik = uzytkownik;
        this.wartoscKredytu = wartoscKredytu;
        this.okresSplaty = okresSplaty;
        this.oprocentowanie = oprocentowanie;
        wartoscDoSplaty = wartoscKredytu;
    }
}
