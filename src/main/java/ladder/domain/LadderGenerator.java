package ladder.domain;

public class LadderGenerator {

    private final int playerCount;
    private final int ladderHeight;

    public LadderGenerator(final int playerCount, int ladderHeight) {
        this.playerCount = playerCount;
        this.ladderHeight = ladderHeight;
    }

    public Lines generateLines() {
        Lines lines = new Lines();
        for (int i = 0; i < ladderHeight; i++) {
            lines = lines.addLine(Line.of(playerCount));
        }
        return lines;
    }
}
