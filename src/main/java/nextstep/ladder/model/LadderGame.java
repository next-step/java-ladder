package nextstep.ladder.model;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final List<Player> players;

    public LadderGame(Ladder ladder, List<Player> players) {
        this.ladder = ladder;
        this.players = players;
    }

    public List<Player> move() {
        players.forEach(ladder::move);

        return this.players;
    }
}
