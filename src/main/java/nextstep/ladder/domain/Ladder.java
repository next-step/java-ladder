package nextstep.ladder.domain;

public class Ladder {
    private Lines lines;

    public Ladder(final int width, final int height) {
        this.lines = new Lines(width, height);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lines.toString());
        return stringBuilder.toString();
    }
}
