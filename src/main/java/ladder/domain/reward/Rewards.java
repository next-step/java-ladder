package ladder.domain.reward;

import ladder.domain.player.Name;
import ladder.domain.player.Players;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Rewards {

    private final List<Reward> rewards;

    private Rewards(List<Reward> rewards, Players players) {
        this.rewards = Optional.ofNullable(rewards)
                .filter(rewards1 -> isCountMatch(players, rewards1))
                .orElseThrow(() -> new IllegalArgumentException("상품의 수는 플레이어 수와 동일해야 합니다."));
    }

    private boolean isCountMatch(Players players, List<Reward> rewards1) {
        return rewards1.size() == players.getCount();
    }

    public static Rewards create(List<Reward> rewards, Players players) {
        return new Rewards(rewards, players);
    }

    public List<String> getNames() {
        return rewards.stream()
                .map(Reward::getName)
                .map(Name::getValue)
                .collect(Collectors.toList());
    }
}
