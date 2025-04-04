package ladder.domain;

public class LadderGame {
    private final int height;
    private final int width;

    public LadderGame(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public Ladder createLadder() {
        return new Ladder(height, width);
    }
}
