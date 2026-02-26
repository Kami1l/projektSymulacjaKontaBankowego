import java.util.Arrays;
import java.util.List;

public class Kantor {

    Konto kontoZakladajace;

    List<String> waluty = Arrays.asList("USD","RUB","EUR");
    float[] wartosciWalut = {3.42F,1.45F,4.17F};
    float[] stanKontaKantorowego = new float[waluty.size()];

    // Trzeba zrobic jakies przeliczniki normalne dla tych walut !!!!

    void operacjaZmianyWaluty(float[] konto,String walutaWejsciowa,String walutaWyjsciowa,float kwota){

        for(String waluta: waluty){
            if(walutaWejsciowa.equals(waluta)){
                if(walutaWyjsciowa.equals(waluta)){
                    System.out.println("Nie mozna wymienic :" + walutaWejsciowa + " na " + walutaWejsciowa);
                }else{
                    System.out.println(waluty.indexOf(walutaWejsciowa)+" | "+waluty.indexOf(walutaWyjsciowa));
                    stanKontaKantorowego[waluty.indexOf(walutaWejsciowa)] -= kwota;
                    stanKontaKantorowego[waluty.indexOf(walutaWyjsciowa)] += kwota*wartosciWalut[waluty.indexOf(walutaWyjsciowa)];

                    System.out.println("Kantor waluta: "+ waluta + " i stan waluty:" + stanKontaKantorowego[waluty.indexOf(walutaWejsciowa)]);
                    System.out.println("Stan " + walutaWyjsciowa + " na ktora wmieniono : " + stanKontaKantorowego[waluty.indexOf(walutaWyjsciowa)]);
                }

            }else{
                //System.out.println("Brak takiej waluty");
            }
        }
    }

    public Kantor(Konto kontoZakladajace){
        this.kontoZakladajace = kontoZakladajace;
    }
}
