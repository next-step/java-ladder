package ladder.domain;

public class Ladder {

    public static final int LADDER_WIDTH = 5;

    private int height;
    private Line line;

    public Ladder(int height, Line line) {
        this.height = height;
        this.line = line;
    }

    public String draw() {
        return "";
    }

}
