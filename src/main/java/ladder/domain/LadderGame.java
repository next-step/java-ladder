package ladder.domain;

public class LadderGame {
    private Ladder ladder;
    private LadderGoals ladderGoals;

    public LadderGame(Ladder ladder, LadderGoals ladderGoals) {
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
