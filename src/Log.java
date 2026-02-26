/*
Dla każdej operacji (np. przelew, zmiana limitu, logowanie, podgląd danych):

eventId (UUID), timestamp (UTC), system/service

userId / customerId (nie PESEL wprost), sessionId

actorType (klient / pracownik / system)

operation (np. TRANSFER_CREATE), status (SUCCESS/FAIL)

requestId / correlationId (do śledzenia między usługami)

ip, device, channel (WWW/mobile/API)

co się zmieniło: np. fromAccount, toAccount, amount, currency (dla transferu)

errorCode + krótki opis (bez wrażliwych danych)
 */

import java.time.LocalDateTime;
import java.util.UUID;

public class Log {

    int idUzytkownika;
    int idSesji;
    float kwotaOperacji;
    String typAkcji;
    String statusOperacji;
    public final LocalDateTime czasOperacji = LocalDateTime.now();
    public final UUID idLog = UUID.randomUUID();


    public void podajLog(){

        System.out.println("Id uzytkownika: " + idUzytkownika);
        System.out.println("Id operacji: " + idLog);
        System.out.println("Id sesji: " + idSesji);
        System.out.println("KwotaOperacji: " + kwotaOperacji);
        System.out.println("Status operacji: " + statusOperacji);
        System.out.println("Typ akcji: " + typAkcji);
        System.out.println("CzasOperacji: " + czasOperacji);
    }

    public Log(int idUzytkownika , int idSesji,float kwotaOperacji,String typAkcji,String statusOperacji) {
        this.idUzytkownika = idUzytkownika;
        this.idSesji = idSesji;
        this.kwotaOperacji = kwotaOperacji;
        this.typAkcji = typAkcji;
        this.statusOperacji = statusOperacji;
    }

    @Override
    public String toString() {
        return czasOperacji + " | Typ :" + typAkcji + " | Status :" + statusOperacji + " | Uzytkownik: " + idUzytkownika
                + " | id operacji" + idLog + " | Id sesji"+ idSesji + " | KwotaOperacji: " + kwotaOperacji;
    }
}
