package ladder.domain;

public class LadderGame {

    public Ladder createLadder(LadderRecord ladderRecord, int height) {
        Ladder ladder = new Ladder(ladderRecord, height);
        ladder.createLines(ladderRecord.getWidth());

        return ladder;
    }

    public GameResult run(LadderRecord ladderRecord, Ladder ladder) {
        return new GameResult(ladderRecord.run(ladder.getLines()));
    }
}
