package ladder;

public class LadderGameData {

    private final Ladder ladder;
    private Rewards rewards;

    public LadderGameData(Ladder ladder, Rewards rewards) {
        this.ladder = ladder;
        this.rewards = rewards;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public Rewards getRewards() {
        return this.rewards;
    }

}
