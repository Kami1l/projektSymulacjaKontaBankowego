import java.util.UUID;

public class Przelew {
    Konto kontoWysylajace;
    Konto kontoOdbierajace;
    float kwota;
    int idOperacji = 5; // statycznie wygenerowany id operacji %% do zrobienia
    Awarie awaria = new Awarie(idOperacji);
    String[] stanPrzelewu = {"OK","Nie Udana"};

    public void wyslaniePrzelewu(){
        awaria.powstanieAwarii(idOperacji);
        System.out.println("Wyslanie przelewu na kwote : " + kwota);
        System.out.println("Na konto: " + kontoOdbierajace.nazwaUzytkownika);
        kontoWysylajace.stanKonta = kontoWysylajace.dajStanKonta() - kwota;
        kontoOdbierajace.stanKonta = kontoOdbierajace.stanKonta + kwota;
        System.out.println("Bilans po operacji:" + kontoWysylajace.stanKonta);
        System.out.println("Bilans po operacji odbiorcy:" + kontoOdbierajace.stanKonta);
        kontoWysylajace.dodajLog(new Log(kontoWysylajace.id,999,"Przelew",(awaria.powstanieAwarii(idOperacji)) ? "OK" : "Nie OK",idOperacji));
    }

    public Przelew(Konto kontoWysylajace,Konto kontoOdbierajace,float kwota){
        this.kontoOdbierajace = kontoOdbierajace;
        this.kontoWysylajace = kontoWysylajace;
        this.kwota = kwota;
    }
}
