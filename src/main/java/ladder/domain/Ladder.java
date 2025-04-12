package ladder.domain;

import ladder.generator.BridgeGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Row> rows;

    private Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public static Ladder generateLadder(int playerCount, int height, BridgeGenerator bridgeGenerator) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> Row.generateRow(playerCount, bridgeGenerator))
                .collect(Collectors.toList()));
    }

    public int move(int startPosition) {
        int resultPosition = startPosition;

        for (Row row : rows) {
            resultPosition = row.move(resultPosition);
        }

        return resultPosition;
    }

    public int getLadderHeight() {
        return rows.size();
    }

    public List<Row> getRows() {
        return rows;
    }
}
