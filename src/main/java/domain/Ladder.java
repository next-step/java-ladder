package domain;

public class Ladder {
    private final Lines lines;

    private Ladder(final Lines lines) {
        this.lines = lines;
    }

    public static Ladder of(final Length width, final Length height) {
        Lines lines = Lines.of(width, height);

        return new Ladder(lines);
    }

    public Lines getLines() {
        return lines;
    }

    public int ride(int position) {
        return lines.departsAt(position);
    }
}
