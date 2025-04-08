package ladder.domain;

import ladder.generator.RandomBridgeGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder generateRandomLadder(Players players, Height height) {
        return generateRandomLadder(players.getPlayerCount(), height.getHeight());
    }

    public static Ladder generateRandomLadder(int playerCount, int height) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> Row.generateRow(playerCount, new RandomBridgeGenerator()))
                .collect(Collectors.toList()));
    }

    public int getLadderHeight() {
        return rows.size();
    }

    public List<Row> getRows() {
        return rows;
    }
}
