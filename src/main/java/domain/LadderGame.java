package domain;

import java.util.function.Consumer;

public class LadderGame {
    private LadderGenerator ladderGenerator;
    private Ladder ladder;

    public LadderGame(LadderGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
    }

    public void generate(int height, int countOfPlayers) {
        this.ladder = ladderGenerator.generate(height, countOfPlayers - 1);
    }

    public void paint(Consumer<Line> consumer) {
        ladder.paint(consumer);
    }

    public LadderGameResult getResult() {
        return ladder.getResult();
    }
}
