package nextstep.ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final Ladder ladder;
    private final List<Player> players;

    public LadderGame(Ladder ladder, List<Player> players) {
        this.ladder = ladder;
        this.players = players;
    }

    public List<Player> result() {
        return players.stream()
                .map(ladder::move)
                .collect(Collectors.toList());
    }
}
