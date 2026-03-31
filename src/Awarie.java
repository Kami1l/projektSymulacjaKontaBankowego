import static java.lang.Math.random;

public class Awarie {

    int idOperacji;
    double losowanie = random();

    public boolean wystapienieAwarii(int idOperacji){
        if(losowanie <= 0.1){
            System.out.println("AWARIA");
           return powstanieAwarii(idOperacji);
        }
        System.out.println("BRAK");
        return false;
    }

    public boolean powstanieAwarii(int idOperacji){
        return switch (idOperacji) {
            case 1 -> {
                System.out.println("Przelew nie powiodla sie");
                yield true;
            }
            case 2 -> {
                System.out.println("Wymiana nie powiodla sie");
                yield true;
            }
            case 3 -> {
                System.out.println("Blik nie powiodla sie");
                yield true;
            }
            case 4 -> {
                System.out.println("Kredyt nie powiodla sie");
                yield true;
            }
            case 5 -> {
                System.out.println("Splata raty nie powiadla sie");
                yield true;
            }
            case 6 -> {
                System.out.println("Naliczenie raty nie powiadla sie");
                yield true;
            }
            case 7 -> {
                System.out.println("Nie udalo sie wziac kredytu");
                yield true;
            }
            default -> false;
        };
    }

    public Awarie(int idOperacji){
        this.idOperacji = idOperacji;

    }
}
