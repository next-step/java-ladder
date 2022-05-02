package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.*;

public class Ladders {

    private final List<Line> lines;
    private final LaddersResults laddersResults;

    private Ladders(int countOfPlayer, int maxHeight, LaddersResults laddersResults) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < maxHeight; i++) {
            lines.add(new Line(countOfPlayer));
        }
        this.laddersResults = laddersResults;
    }

    private Ladders(List<Line> lines, LaddersResults laddersResults) {
        this.lines = lines;
        this.laddersResults = laddersResults;
    }

    public static Ladders makeLaddersByPlayersAndHeight(int countOfPlayer, int maxHeight, LaddersResults laddersResults) {
        return new Ladders(countOfPlayer, maxHeight, laddersResults);
    }

    public static Ladders makeDefaultLadders(List<Line> lines, LaddersResults laddersResults) {
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
