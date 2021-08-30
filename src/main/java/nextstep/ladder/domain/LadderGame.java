package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final List<Player> players;
    private final Ladder ladder;

    public LadderGame(final List<String> players, final int height) {
        this.players = Collections.unmodifiableList(
                players.stream()
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
        this.ladder = new Ladder(players.size(), height);
    }

    public Ladder valueOfLadder() {
        return ladder;
    }

    public List<Player> valueOfPlayers() {
        return players;
    }
}
