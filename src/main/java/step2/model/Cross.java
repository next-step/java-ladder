package step2.model;

public class Cross {

    public static int move(int index, Direction direction) {
        return index + direction.getMove();
    }
}
