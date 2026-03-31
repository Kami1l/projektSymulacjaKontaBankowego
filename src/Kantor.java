import java.util.*;

public class Kantor {

    Konto kontoZakladajace;
    int idOperacji = 2;

    List<String> waluty = Arrays.asList("USD","RUB","EUR","PLN");
    float[] wartosciWalut = {3.42F,1.45F,4.17F,1.00F};
    float[] stanKontaKantorowego = new float[waluty.size()];


    // Trzeba zrobic jakies przeliczniki normalne dla tych walut !!!!

    void operacjaZmianyWaluty(Konto konto, String walutaWejsciowa, String walutaWyjsciowa, float kwota){
        Awarie awaria = new Awarie(idOperacji);

        int indexWej = waluty.indexOf(walutaWejsciowa);
        int indexWyj = waluty.indexOf(walutaWyjsciowa);

        if(awaria.wystapienieAwarii(idOperacji)){
            kontoZakladajace.dodajLog(new Log(kontoZakladajace.id,kwota,idOperacji,"FAILED",idOperacji));
        }else {
            if(!waluty.contains(walutaWejsciowa)){
                kontoZakladajace.dodajLog(new Log(kontoZakladajace.id,kwota,idOperacji,"FAILED: BRAK TAKIEJ WALUTY",idOperacji));
            }else{
                if(walutaWyjsciowa.equals(walutaWejsciowa)){
                    kontoZakladajace.dodajLog(new Log(kontoZakladajace.id,kwota,idOperacji,"FAILED: WYMIANA WALUTY NA TA SAMA",idOperacji));
                }else{
                        System.out.println(indexWej+" | "+indexWyj);
                        stanKontaKantorowego[indexWej] -= kwota;
                        stanKontaKantorowego[indexWyj] += kwota*wartosciWalut[indexWyj];

                        System.out.println("Kantor waluta: "+ walutaWejsciowa + " i stan waluty:" + stanKontaKantorowego[indexWej]);
                        System.out.println("Stan " + walutaWyjsciowa + " na ktora wmieniono : " + stanKontaKantorowego[indexWyj]);

                        kontoZakladajace.dodajLog(new Log(kontoZakladajace.id,kwota,idOperacji,"OK",idOperacji));
                }
            }

        }
    }

    public Kantor(Konto kontoZakladajace){
        this.kontoZakladajace = kontoZakladajace;
    }


}
