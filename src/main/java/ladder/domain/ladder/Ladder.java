package ladder.domain.ladder;

import ladder.domain.player.Players;
import ladder.domain.row.Rows;

public class Ladder {
    public static final int INITIAL_HEIGHT = 0;

    private final Players players;
    private final Rows rows;

    public Ladder(Players players, Rows rows) {
        validate(players, rows);
        this.players = players;
        this.rows = rows;
    }

    private void validate(Players players, Rows rows) {
        if (players == null) {
            throw new IllegalArgumentException("players는 null 일 수 없습니다.");
        }
        if (rows == null) {
            throw new IllegalArgumentException("rows는 null 일 수 없습니다.");
        }
    }

    public static Ladder of(Players players, int height) {
        return new Ladder(
                players,
                Rows.of(players.size(), height)
        );
    }

    public Rows getRows() {
        return rows;
    }

    public Players getPlayers() {
        return players;
    }
}
