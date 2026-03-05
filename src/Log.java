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
    int idOperacji;

    public Log(int idUzytkownika,float kwotaOperacji,String typAkcji,String statusOperacji,int idOperacji) {
        this.idUzytkownika = idUzytkownika;
        this.kwotaOperacji = kwotaOperacji;
        this.typAkcji = typAkcji;
        this.statusOperacji = statusOperacji;
        this.idOperacji = idOperacji;
    }

    @Override
    public String toString() {
        return "Czas : " + czasOperacji + "Id operacji: "+ idOperacji + " | Status: " + statusOperacji + " | Uzytkownik: " + idUzytkownika
                + " | id logu: " + idLog + " | KwotaOperacji: " + kwotaOperacji ;

    }
}
