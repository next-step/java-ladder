package nextstep.ladder.domain;

public class Ladder {
    private Lines lines;

    public Ladder(final int width, final int height) {
        this.lines = new Lines(width, height);
    }

    public void start(final Participants participants, final Result result) {
        throw new UnsupportedOperationException("Unsupported start");
    }

    @Override
    public String toString() {
        return lines.toString();
    }
}
