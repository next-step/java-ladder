package ladder.domain;

import ladder.utils.RandomUtils;

public class LadderGenerator {

    private final int playerCount;
    private final int ladderHeight;

    public LadderGenerator(final int playerCount, int ladderHeight) {
        this.playerCount = playerCount;
        this.ladderHeight = ladderHeight;
    }

    public Line generateLine() {
        Line line = new Line();
        for (int i = 0; i < playerCount; i++) {
            boolean randomBoolean = RandomUtils.getRandomBoolean();
            line = line.addRandomNextNode(randomBoolean);
        }
        return line;
    }
}
