package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class Ladders {

    public static final int START_INCLUSIVE = 1;

    private final List<Line> lines;
    private final LaddersResults laddersResults;

    private Ladders(int countOfPlayer, int maxHeight, LaddersResults laddersResults) {
        this.lines = IntStream.rangeClosed(START_INCLUSIVE, maxHeight)
                .mapToObj(index -> new Line(countOfPlayer))
                .collect(toList());

        this.laddersResults = laddersResults;
    }

    private Ladders(List<Line> lines, LaddersResults laddersResults) {
        this.lines = lines;
        this.laddersResults = laddersResults;
    }

    public static Ladders of(int countOfPlayer, int maxHeight, LaddersResults laddersResults) {
        return new Ladders(countOfPlayer, maxHeight, laddersResults);
    }

    public static Ladders getDefault(List<Line> lines, LaddersResults laddersResults) {
        return new Ladders(lines, laddersResults);
    }

    public List<Line> getLines() {
        return unmodifiableList(lines);
    }

    public String findLadderResult(int startPosition) {
        int resultColumn = startPosition;

        for (Line line : lines) {
            if (line.canGoRight(resultColumn)) {
                resultColumn++;
                continue;
            }

            if (line.canGoLeft(resultColumn)) {
                resultColumn--;
            }
        }

        return laddersResults.findLadderResultByEndPosition(resultColumn);
    }

    public Map<String, String> findAllLadderResult(Players players) {
        Map<String, String> results = new HashMap<>();
        List<PlayerName> playerList = players.getPlayers();
        for (int i = 0; i < playerList.size(); i++) {
            results.put(playerList.get(i).getPlayerName(), findLadderResult(i));
        }
        return results;
    }
}
