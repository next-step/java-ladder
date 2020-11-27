package domain;

public class Ladder {
    private Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(int width, int height) {
        Lines lines = Lines.of(width, height);

        return new Ladder(lines);
    }

    public Lines getLines() {
        return lines;
    }
}
