public class idGen {
    private static int id = 0;

    public static int next(){
        id++;
        return id;
    }
}
