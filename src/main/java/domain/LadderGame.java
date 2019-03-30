package domain;

import java.util.function.Consumer;

public class LadderGame {
    private LadderGenerator ladderGenerator;
    private Ladder ladder;

    public LadderGame(LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public void generate(int height, int countOfUsers) {
        this.ladder = ladderGenerator.generate(height, countOfUsers - 1);
    }

    public void paint(Consumer<Line> consumer) {
        ladder.paint(consumer);
    }
}
