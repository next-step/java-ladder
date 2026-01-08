package nextstep.ladder.domain;

import java.util.List;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;

    public LadderGame(String players, Ladder ladder) {
        this(new Players(players), ladder);
    }

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public List<Player> getPlayers() {
        return this.players.getPlayers();
    }
}
