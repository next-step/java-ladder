package ladder.domain.ladder;

import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.reward.Reward;
import ladder.domain.reward.Rewards;

import java.util.stream.Collectors;

public class LadderGame {
    private final Ladder ladder;
    private final Rewards rewards;

    public LadderGame(Ladder ladder, Rewards rewards) {
        validate(ladder, rewards);
        this.ladder = ladder;
        this.rewards = rewards;
    }

    private void validate(Ladder ladder, Rewards rewards) {
        if (ladder == null) {
            throw new IllegalArgumentException("ladder는 null일 수 없습니다.");
        }

        if (rewards == null) {
            throw new IllegalArgumentException("rewards는 null일 수 없습니다.");
        }
    }

    public Results play(Players players) {
        return new Results(
                players.getPlayers()
                        .stream()
                        .map(player -> Result.of(player, play(player)))
                        .collect(Collectors.toList())
        );
    }

    private Reward play(Player player) {
        return rewards.findByPosition(
                ladder.trace(player.position())
        );
    }

    public static LadderGame of(Ladder ladder, Rewards rewards) {
        return new LadderGame(ladder, rewards);
    }
}
