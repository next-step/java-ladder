package ladder.domain;

public class LadderEdge {

    private final Players players;
    private final Rewards rewards;

    public LadderEdge(Players players, Rewards rewards) {
        this.players = players;
        this.rewards = rewards;
    }

    public int playerSize() {
        return this.players.size();
    }

    public Player player(int index) {
        return this.players.getPlayer(index);
    }

    public Reward reward(int index) {
        return this.rewards.getReward(index);
    }
}
