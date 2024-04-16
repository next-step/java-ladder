package domain;

public class GameResult {

    private final Player player;
    private final Reward reward;

    public GameResult(Player player, Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    public Player getPlayer() {
        return player;
    }

    public Reward getReward() {
        return reward;
    }
}
