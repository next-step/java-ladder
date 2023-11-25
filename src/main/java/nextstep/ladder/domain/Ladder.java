package nextstep.ladder.domain;

public class Ladder {
    private Lines lines;

    public Ladder(final int width, final int height) {
        this.lines = new Lines(width, height);
    }

    @Override
    public String toString() {
        return lines.toString();
    }
}
