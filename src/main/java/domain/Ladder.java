package domain;

public class Ladder {
    private Lines lines;

    private Ladder(Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(int width, int height) {
        Lines lines = new Lines();
        for(int i = 0; i < height; i++) {
            lines.add(new Line(width));
        }

        return new Ladder(lines);
    }

    public Lines getLines() {
        return lines;
    }
}
