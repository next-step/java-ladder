package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final List<Player> players;

    public Ladder(final List<Player> players, final Height height, final Supplier<Boolean> linePredicate) {
        final PlayerCount playerCount = new PlayerCount(players.size());
        for (int i = 0; i < height.height(); i++) {
            lines.add(new Line(playerCount, linePredicate));
        }
        this.players = players;
    }

    public List<Player> players() {
        return players;
    }

    public List<Line> lines() {
        return lines;
    }
}
