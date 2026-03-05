import java.util.UUID;

public class Awarie {

    int idOperacji;

    public boolean powstanieAwarii(int idOperacji){
        switch(idOperacji){
            case 1:
                System.out.println("Przelew nie powiodla sie");
                return true;
            case 2:
                System.out.println("2 nie powiodla sie");
                return true;
            case 3:
                System.out.println("3 nie powiodla sie");
                return true;
            default:
                return false;

        }
    }

    public Awarie(int idOperacji){
        this.idOperacji = idOperacji;

    }
}
