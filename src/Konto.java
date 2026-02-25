public class Konto {
    String nazwaUzytkownika;
    String hasloUzytkownika;
    int blik;
    float stanKonta;

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
