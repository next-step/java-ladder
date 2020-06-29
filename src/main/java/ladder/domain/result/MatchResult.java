package ladder.domain.result;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderMatch;
import ladder.domain.player.Player;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MatchResult {

    private final Map<Player, Reward> matches = new HashMap<>();

    private MatchResult(Ladder ladder, Rewards rewards) {
        Optional.ofNullable(ladder).orElseThrow(IllegalArgumentException::new);
        Optional.ofNullable(rewards).orElseThrow(IllegalArgumentException::new);

        while (ladder.hasNext()) {
            LadderMatch ladderMatch = ladder.start();
            matches.put(ladderMatch.getPlayer(), rewards.findReward(ladderMatch.getPosition()));
        }
    }

    public static MatchResult create(Ladder ladder, Rewards rewards) {
        return new MatchResult(ladder, rewards);
    }

    public Reward findPlayer(Player player) {
        if (!matches.containsKey(player)) {
            throw new IllegalArgumentException("존재하지 않는 Player 입니다.");
        }

        return matches.get(player);
    }

    public Map<Player, Reward> getAllPlayer() {
        return Collections.unmodifiableMap(matches);
    }
}
