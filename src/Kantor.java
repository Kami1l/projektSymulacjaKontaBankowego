public class Kantor {

    Konto kontoZakladajace;

    String[] waluty = {"USD","RUB","EUR"};
    float[] wartosciWalut = {3.42F,1.45F,4.17F};
    float[] stanKontaKantorowego = new float[waluty.length];

    void operacjaZmianyWaluty(float kwota,String walutaWejsciowa,String walutaWyjsciowa){
        switch(walutaWyjsciowa){
            case "USD":
                if(walutaWyjsciowa.equals(walutaWejsciowa)){
                    System.out.println("NIE MOZNA WYMIENIC USD NA USD :) ");
                }else{
                    stanKontaKantorowego[0] = stanKontaKantorowego[0] + kwota*wartosciWalut[0];
                }

                break;
            case "RUB":
                if(walutaWyjsciowa.equals(walutaWejsciowa)){
                    System.out.println("NIE MOZNA WYMIENIC RUB NA RUB :) ");
                }else{
                    stanKontaKantorowego[1] = stanKontaKantorowego[1] + kwota*wartosciWalut[1];
                }

                break;
            case "EUR":
                if(walutaWyjsciowa.equals(walutaWejsciowa)){
                    System.out.println("NIE MOZNA WYMIENIC EUR NA EUR :) ");
                }else{
                    stanKontaKantorowego[2] = stanKontaKantorowego[2] + kwota*wartosciWalut[2];
                }

                break;
        }
    }

    public Kantor(Konto kontoZakladajace){
        this.kontoZakladajace = kontoZakladajace;
    }
}
