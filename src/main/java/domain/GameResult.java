package domain;

public class GameResult {

    private final Player player;
    private final Reward reward;

    private GameResult(Player player, Reward reward) {
        this.player = player;
        this.reward = reward;
    }

    public static GameResult createResult(Ladder ladder, Players players, Rewards rewards, Player player) {
        return new GameResult(player, rewards.findByOrder(ladder.getEndColumn(players.getOrder(player))));
    }

    public Player getPlayer() {
        return player;
    }

    public Reward getReward() {
        return reward;
    }
}
