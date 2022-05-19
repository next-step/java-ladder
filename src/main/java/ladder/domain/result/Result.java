package ladder.domain.result;

import ladder.domain.player.Player;
import ladder.domain.reward.Reward;

public class Result {
    private final Player player;
    private final Reward reward;

    public Result(Player player, Reward reward) {
        validate(player, reward);
        this.player = player;
        this.reward = reward;
    }

    private void validate(Player player, Reward reward) {
        if (player == null) {
            throw new IllegalArgumentException("player는 null일 수 없습니다.");
        }
        if (reward == null) {
            throw new IllegalArgumentException("reward는 null일 수 없습니다.");
        }
    }

    public Player player() {
        return player;
    }

    public Reward reward() {
        return reward;
    }

    public static Result of(Player player, Reward reward) {
        return new Result(player, reward);
    }
}
