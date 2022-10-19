package nextstep.laddar;

public class app {

    public static void main(String[] args) {
        Laddar laddar = new Laddar(5, 4, new RandomGenerator());
        System.out.println(laddar.toString());
    }

}
