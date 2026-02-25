public class Przelew {
    Konto kontoWysylajace;
    Konto kontoOdbierajace;
    float kwota;

    public void wyslaniePrzelewu(){
        System.out.println("Wyslanie przelewu na kwote : " + kwota);
        System.out.println("Na konto: " + kontoOdbierajace.nazwaUzytkownika);
        kontoWysylajace.stanKonta = kontoWysylajace.dajStanKonta() - kwota;
        kontoOdbierajace.stanKonta = kontoOdbierajace.stanKonta + kwota;
        System.out.println("Bilans po operacji:" + kontoWysylajace.stanKonta);
        System.out.println("Bilans po operacji odbiorcy:" + kontoOdbierajace.stanKonta);
    }

    public Przelew(Konto kontoWysylajace,Konto kontoOdbierajace,float kwota){
        this.kontoOdbierajace = kontoOdbierajace;
        this.kontoWysylajace = kontoWysylajace;
        this.kwota = kwota;
    }
}
