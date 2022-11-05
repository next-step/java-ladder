package ladder.model;

public class LadderGame {

    private Ladder ladder;
    private LadderRewards ladderRewards;

    public LadderGame(String[] ladderReward, int playerCount, int height) {
        this.ladder = new Ladder(playerCount, height);
        this.ladderRewards = LadderRewards.of(ladderReward);
    }

    public LadderRewards getResult() {
        return ladderRewards.getRewardsByRank(ladder.getResult());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderRewards getLadderRewards() {
        return ladderRewards;
    }
}
