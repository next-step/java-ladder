package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MIN_HEIGHT_OF_LADDER = 1;

    private final List<String> playerNames;

    private final List<String> result;

    private final List<Line> lines;

    public Ladder(List<String> playerNames, List<Line> lines, List<String> result) {
        if (playerNames.size() != result.size()) {
            throw new IllegalArgumentException("플레이어와 결과의 수는 동일해야 합니다.");
        }

        this.playerNames = playerNames;
        this.lines = lines;
        this.result = result;
    }

    public static Ladder of(List<String> playerNames, int maxHeightOfLadder, List<String> result) {
        if (maxHeightOfLadder < MIN_HEIGHT_OF_LADDER) {
            throw new IllegalArgumentException("최소 높이는 최소 " + MIN_HEIGHT_OF_LADDER + "이상이어야 합니다.");
        }

        List<Line> lines = IntStream.range(0, maxHeightOfLadder)
                .mapToObj(idx -> Line.of(playerNames.size()))
                .collect(Collectors.toList());

        return new Ladder(playerNames, lines, result);
    }

    public List<Line> lines() {
        return new ArrayList<>(lines);
    }

    public String play(String playerName) {
        int position = playerNames.indexOf(playerName);

        for (Line line : lines) {
            Point prevPoint = null;
            if (position - 1 > 0) {
                prevPoint = line.points().get(position - 1);
            }
            Point curPoint = line.points().get(position);
            if (prevPoint != null && prevPoint.isActive()) {
                position -= 1;
            }

            if (prevPoint != null && !prevPoint.isActive() && curPoint != null && curPoint.isActive()) {
                position += 1;
            }
        }

        return result.get(position);
    }
}
