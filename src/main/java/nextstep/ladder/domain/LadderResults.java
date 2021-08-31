package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResults {
    private final List<Player> players;
    private final List<String> results;

    public LadderResults(final List<String> players, final List<String> results) {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException("결과 수와 참여자 수는 같아야 합니다.");
        }
        this.players = Collections.unmodifiableList(
                players.stream()
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
        this.results = results;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
