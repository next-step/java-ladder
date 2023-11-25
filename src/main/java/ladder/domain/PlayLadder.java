package ladder.domain;

import java.util.Collections;
import java.util.List;

public class PlayLadder {
    private final Players players;
    private final Ladder ladder;

    private PlayLadder(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public static PlayLadder of(Players players, Ladder ladder) {
        return new PlayLadder(players, ladder);
    }

    public List<Player> players() {
        return Collections.unmodifiableList(players.players());
    }

    public List<Line> ladder() {
        return ladder.ladder();
    }

    public long nameLengthMax() {
        return players.nameLengthMax();
    }

}
