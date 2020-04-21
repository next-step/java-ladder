package ladder.domain;

public class Ladder {
    private Ladder(int height) {

    }

    public static Ladder getInstance(int height) {
        return new Ladder(height);
    }

    public int getHeight() {
        return -1;
    }
}
