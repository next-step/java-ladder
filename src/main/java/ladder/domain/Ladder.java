package ladder.domain;

public class Ladder {
    private Height height;

    public Ladder(final Height height) {
        this.height = height;
    }

    public Height height() {
        return height;
    }
}
