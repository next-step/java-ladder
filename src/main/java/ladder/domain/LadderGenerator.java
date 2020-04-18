package ladder.domain;

public class LadderGenerator {
    private Ladder ladder;
    private LadderGoals ladderGoals;

    public LadderGenerator(Ladder ladder, LadderGoals ladderGoals) {
        this.ladder = ladder;
        this.ladderGoals = ladderGoals;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGoals getLadderGoals() {
        return ladderGoals;
    }
}
