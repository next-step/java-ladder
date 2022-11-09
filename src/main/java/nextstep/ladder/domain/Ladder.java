package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final Players players;
    private final List<Row> rows;

    public Ladder(final List<String> playerNames, final int rowCount) {
        this.players = Players.of(playerNames);
        this.rows = buildRows(rowCount, playerNames.size());
    }

    private List<Row> buildRows(final int rowCount, final int columnCount) {
        return IntStream.range(0, rowCount)
                .mapToObj(i -> new Row(columnCount))
                .collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return this.players.getSize();
    }

    public Players getPlayers() {
        return this.players;
    }

    public List<Row> getRows() {
        return this.rows;
    }
}
