import java.util.Random;

public class Blik {
    Konto kontoBlikujace;
    Konto odbierajaceBlik;
    float kwota;
    int kodBlik;

    public int generowanieKoduBlik(){

        Random random = new Random();
        kodBlik = 100000 + random.nextInt(900000);
        System.out.println("Wygenerowano kod blik :"+kodBlik);
        return kodBlik;
    }

    public void przelewBlik(int podanyKodBlik){

        if(podanyKodBlik == kodBlik){
            System.out.println("Wyslanie przelewu BLIK na kwote : " + kwota);
            System.out.println("Na konto: " + odbierajaceBlik.nazwaUzytkownika);
            kontoBlikujace.stanKonta = kontoBlikujace.dajStanKonta() - kwota;
            odbierajaceBlik.stanKonta = odbierajaceBlik.stanKonta + kwota;
            System.out.println("Bilans po BLIK:" + kontoBlikujace.stanKonta);
            System.out.println("Bilans po BLIK odbiorcy:" + odbierajaceBlik.stanKonta);
        }else{
            System.out.println("KOD BLIK NIEPOPRAWNY !!!");
        }

    }

    public Blik(Konto kontoBlikujace,Konto odbierajaceBlik,float kwota){
        this.kontoBlikujace = kontoBlikujace;
        this.odbierajaceBlik = odbierajaceBlik;
        this.kwota = kwota;
    }
}
