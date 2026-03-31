import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Konto {
    String nazwaUzytkownika;
    String hasloUzytkownika;
    int blik;
    float stanKonta;
    int id;

    List<Log> zbiorLogow = new ArrayList<>(); // Lista stworzonych logow DYNAMICZNA

    public void dodajLog(Log log){
        zbiorLogow.add(log);
    }

    public List<Log> wezLogi(){
        return Collections.unmodifiableList(zbiorLogow);
    }

    public boolean stanKonta(){
        int idOperacji = 21;
        System.out.println(stanKonta);
        dodajLog(new Log(id,stanKonta,idOperacji,"Wplacono pieniadze",idOperacji));
        return false;
    }

    public float dajStanKonta(){
        return stanKonta;
    }

    public void wplacPieniadze(int wplata){
        int idOperacji = 20;
        stanKonta += wplata;
        System.out.println("Wplacono : " + wplata + " Aktualny stan konta :"+ stanKonta);
        dodajLog(new Log(id,wplata,idOperacji,"Wplacono pieniadze",idOperacji));

    }

    public Optional<Kredyt> wezKredyt(float  wartoscKredytu, float okresSplaty, float oprocentowanie) {
        int idOperacji = 7;
        Awarie awaria = new Awarie(idOperacji);

        if(awaria.wystapienieAwarii(idOperacji)){
           dodajLog(new Log(id,wartoscKredytu,idOperacji,"FAILED: Nie udalo sie wziac kredytu",idOperacji));
           return Optional.empty();
        }else{
            return Optional.of(new Kredyt(this, wartoscKredytu, okresSplaty, oprocentowanie));
        }

    }

    public Kantor otworzKantor(){
        int idOperacji = 8;
        Awarie awaria = new Awarie(idOperacji);

        if(awaria.wystapienieAwarii(idOperacji)){
            dodajLog(new Log(id,0,idOperacji,"FAILED: Nie udalo sie stworzyc kantoru",idOperacji));
            return null;
        }else{
            return new Kantor(this);
        }
    }

    public void wyplacPieniadze(int wyplata){
        int idOperacji = 22;
        if(stanKonta < wyplata){
            System.out.println("Brak odpowiednich środków na koncie !");
            dodajLog(new Log(id,wyplata,idOperacji,"Wyplacono pieniadze",idOperacji));
        }else{
            stanKonta -= wyplata;
            System.out.println("Wyplacono : " + wyplata + " Aktualny stan konta :"+ stanKonta);
            dodajLog(new Log(id,wyplata,idOperacji,"Wyplacono pieniadze",idOperacji));
        }

    }

    public Konto(String nazwaUzytkownika, String hasloUzytkownika, float stanKonta){
        this.hasloUzytkownika = hasloUzytkownika;
        this.nazwaUzytkownika = nazwaUzytkownika;
        this.stanKonta = stanKonta;
        this.id = idGen.next();
    }
}
