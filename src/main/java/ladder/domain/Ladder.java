package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Players players, Height height) {
        return new Ladder(init(players.countOfPlayers(), height.getHeight()));
    }

    private static List<Line> init(int countOfPlayers, int height) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(0, height).forEach((i)-> lines.add(Line.of(new RandomPoints(countOfPlayers))));
        return lines;
    }

    public static Ladder of (List<Line> lines) {
        return new Ladder(lines);
    }

    public int move(int startPoint) {
        for (int i = 0; i < lines.size(); i++) {
            boolean[] visited = new boolean[lines.get(i).numberOfPoints()];
            int result = lines.get(i).move(startPoint, visited);
            startPoint = result;
        }
        return startPoint;
    }

    public int countOfLine() {
        return lines.size();
    }

    public List<Line> getLadder() {
        return lines;
    }

    public List<LadderResult> findGameResult(Players players, Results results, String name) {
        if ("all".equals(name)) {
            return players.getPlayers()
                    .stream()
                    .map(player -> LadderResult.of(player.getName(), findResult(players, results, player.getName())))
                    .collect(Collectors.toList());

        }

        List<LadderResult> ladderResults = new ArrayList<>();
        ladderResults.add(LadderResult.of(name, findResult(players, results, name)));
        return ladderResults;
    }

    private String findResult(Players players, Results results, String name) {
        int endPoint = move(players.findIndexByName(name));
        return results.findResultByIndex(endPoint);
    }
}
