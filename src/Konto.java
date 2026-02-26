import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Konto {
    String nazwaUzytkownika;
    String hasloUzytkownika;
    int blik;
    float stanKonta;

    List<Log> zbiorLogow = new ArrayList<>(); // Lista stworzonych logow DYNAMICZNA

    public void dodajLog(Log log){
        zbiorLogow.add(log);
    }

    public List<Log> wezLogi(){
        return Collections.unmodifiableList(zbiorLogow);
    }

    public void stanKonta(){
        System.out.println(stanKonta);
    }

    public float dajStanKonta(){
        return stanKonta;
    }

    public void wplacPieniadze(int wplata){
        stanKonta += wplata;
        System.out.println("Wplacono : " + wplata + " Aktualny stan konta :"+ stanKonta);
    }

    public Kredyt wezKredyt(float  wartoscKredytu, float okresSplaty,float oprocentowanie) {
        return new Kredyt(this,wartoscKredytu,okresSplaty,oprocentowanie);
    }

    public Kantor otworzKantor(){
        return new Kantor(this);
    }

    public void wyplacPieniadze(int wyplata){
        if(stanKonta < wyplata){
            System.out.println("Brak odpowiednich środków na koncie !");
        }else{
            stanKonta -= wyplata;
            System.out.println("Wyplacono : " + wyplata + " Aktualny stan konta :"+ stanKonta);
        }

    }

    public Konto(String nazwaUzytkownika, String hasloUzytkownika, float stanKonta){
        this.hasloUzytkownika = hasloUzytkownika;
        this.nazwaUzytkownika = nazwaUzytkownika;
        this.stanKonta = stanKonta;
    }
}
