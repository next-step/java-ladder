package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LadderClimber {
    private final Lines lines;
    private final Players players;

    public LadderClimber(Players players, Lines lines) {
        this.players = players;
        this.lines = lines;
    }

    public LineResults climb(LineResult firstLineResult) {
        LineResults lineResults = new LineResults(Collections.singletonList(firstLineResult));

        IntStream.range(0, lines.getHeight())
                .forEach(heightPoint -> {
                    LineResult newLineResult = createNewLineResult(lineResults.getLast(), heightPoint);
                    lineResults.add(newLineResult);
                });

        return lineResults;
    }

    private LineResult createNewLineResult(LineResult lineResult, int heightPoint) {
        List<Connection> connections = lines.getConnectionList(heightPoint);
        LineResult newLineResult = new LineResult(lineResult.getResults());
        IntStream.range(0, players.getSize())
                .forEach(widthPoint -> checkConnection(connections, newLineResult, widthPoint));

        return newLineResult;
    }

    private void checkConnection(List<Connection> connections, LineResult newLineResult, int widthPoint) {
        if (connections.get(widthPoint).isConnected()) {
            newLineResult.swapWithNextPosition(widthPoint);
        }
    }
}
