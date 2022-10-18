package nextstep.ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderWinningResult {

    private final Map<Integer, Integer> ladderResult;

    private LadderWinningResult(final Map<Integer, Integer> ladderResult) {

        this.ladderResult = ladderResult;
    }

    public static LadderWinningResult of(final Ladder ladder) {

        final Map<Integer, Integer> ladderResult = new HashMap<>();
        final List<Line> lines = ladder.getLines();
        for (int i = 0; i < lines.size(); i++) {
            process(ladderResult, lines.get(i), i);
        }
        return new LadderWinningResult(ladderResult);
    }

    private static void process(final Map<Integer, Integer> ladderResult, final Line line, final int row) {

        for (int column = 0; column < line.getPoints().size(); column++) {
            final Point point = findPoint(ladderResult, line, row, column);
            ladderResult.put(column, point.move());
        }
    }

    private static Point findPoint(final Map<Integer, Integer> ladderResult, final Line line, final int row, final int column) {

        if (row == 0) {
            return getPoint(line, column);
        }
        return getPoint(line, ladderResult.get(column));
    }

    private static Point getPoint(final Line line, int point) {

        return line.getPoints().get(point);
    }

    public Map<Integer, Integer> getLadderResult() {

        return Collections.unmodifiableMap(this.ladderResult);
    }

    public int findByName(final int key) {

        return this.ladderResult.get(key);
    }
}
