import java.util.Random;

public class Blik {
    Konto kontoBlikujace;
    Konto odbierajaceBlik;
    float kwota;
    int kodBlik;
    int idOperacji = 3;

    public int generowanieKoduBlik(){

        Random random = new Random();
        kodBlik = 100000 + random.nextInt(900000);
        System.out.println("Wygenerowano kod blik :"+kodBlik);
        return kodBlik;

    }

    public void przelewBlik(int podanyKodBlik){
        Awarie awaria = new Awarie(idOperacji);

        if(awaria.wystapienieAwarii(idOperacji)){
            kontoBlikujace.dodajLog(new Log(kontoBlikujace.id,kwota,idOperacji,"FAILED",idOperacji));
        }else{
            if(podanyKodBlik == kodBlik){
                System.out.println("Wyslanie przelewu BLIK na kwote : " + kwota);
                System.out.println("Na konto: " + odbierajaceBlik.nazwaUzytkownika);
                kontoBlikujace.stanKonta = kontoBlikujace.dajStanKonta() - kwota;
                odbierajaceBlik.stanKonta = odbierajaceBlik.stanKonta + kwota;
                System.out.println("Bilans po BLIK:" + kontoBlikujace.stanKonta);
                System.out.println("Bilans po BLIK odbiorcy:" + odbierajaceBlik.stanKonta);
                kontoBlikujace.dodajLog(new Log(kontoBlikujace.id,kwota,idOperacji,"OK",idOperacji));
            }else{
                System.out.println("KOD BLIK NIEPOPRAWNY !!!");
                kontoBlikujace.dodajLog(new Log(kontoBlikujace.id,kwota,idOperacji,"BAD BLIK CODE",idOperacji));
            }
        }

    }

    public Blik(Konto kontoBlikujace,Konto odbierajaceBlik,float kwota){
        this.kontoBlikujace = kontoBlikujace;
        this.odbierajaceBlik = odbierajaceBlik;
        this.kwota = kwota;
        generowanieKoduBlik();
    }
}
