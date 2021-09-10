package nextstep.laddergame.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        validateLadderLines(lines);
        this.lines = Collections.unmodifiableList(lines);
    }

    private void validateLadderLines(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("사다리를 생성할 수 없습니다.");
        }
    }

    public static Ladder of(Players players, LadderHeights ladderHeights) {
        return new Ladder(createLines(players.size(), ladderHeights));
    }

    private static List<Line> createLines(int countOfPlayer, LadderHeights ladderHeights) {
        return Stream.generate(() -> Line.of(new RandomLineConnectStrategy(new Random(), countOfPlayer)))
                .limit(ladderHeights.getHeights())
                .collect(Collectors.toList());
    }

    public int height() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }

    public Map<PlayerName, String> getResults(Players players, PlayResults playResults) {
        Map<PlayerName, String> ladderResults = new HashMap<>();
        for (int position = 0; position < players.size(); ++position) {
            PlayerName playerName = players.playerNameAt(position);
            String result = playResults.resultAt(resultPositionOf(position));
            ladderResults.put(playerName, result);
        }
        return ladderResults;
    }

    private int resultPositionOf(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }
}
