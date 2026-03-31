import java.util.UUID;

public class Przelew {
    Konto kontoWysylajace;
    Konto kontoOdbierajace;
    float kwota;
    int idOperacji = 1; // statycznie wygenerowany id operacji %% do zrobienia


    public void wyslaniePrzelewu(){
        Awarie awaria = new Awarie(idOperacji);

        if(awaria.wystapienieAwarii(idOperacji)){
            kontoWysylajace.dodajLog(new Log(kontoWysylajace.id,kwota,idOperacji,"FAILED",idOperacji));
        }else{
            System.out.println("Wyslanie przelewu na kwote : " + kwota);
            System.out.println("Na konto: " + kontoOdbierajace.nazwaUzytkownika);

            kontoWysylajace.stanKonta = kontoWysylajace.dajStanKonta() - kwota;
            kontoOdbierajace.stanKonta = kontoOdbierajace.stanKonta + kwota;

            System.out.println("Bilans po operacji:" + kontoWysylajace.stanKonta);
            System.out.println("Bilans po operacji odbiorcy:" + kontoOdbierajace.stanKonta);

            kontoWysylajace.dodajLog(new Log(kontoWysylajace.id,kwota,idOperacji,"OK",idOperacji));
        }
    }

    public Przelew(Konto kontoWysylajace,Konto kontoOdbierajace,float kwota){
        this.kontoOdbierajace = kontoOdbierajace;
        this.kontoWysylajace = kontoWysylajace;
        this.kwota = kwota;
    }
}
