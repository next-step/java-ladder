package nextstep.ladder.codeleesh.view;

import nextstep.ladder.codeleesh.domain.Ladder;
import nextstep.ladder.codeleesh.domain.Line;
import nextstep.ladder.codeleesh.domain.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderWinningResult {

    private final Map<String, String> ladderResult;

    private LadderWinningResult(final Map<String, String> ladderResult) {

        this.ladderResult = ladderResult;
    }

    public static LadderWinningResult of(final Ladder ladder, final List<String> participationNames
            , final List<String> resultNames) {

        return new LadderWinningResult(collect(convert(ladder), participationNames, resultNames));
    }

    private static Map<String, String> collect(final Map<Integer, Integer> ladderResult
            , final List<String> participationNames, final List<String> resultNames) {

        final Map<String, String> ladderResultDto = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : ladderResult.entrySet()) {
            ladderResultDto.put(participationNames.get(entry.getKey()), resultNames.get(entry.getValue()));
        }
        return ladderResultDto;
    }

    private static Map<Integer, Integer> convert(final Ladder ladder) {

        final Map<Integer, Integer> ladderResult = new HashMap<>();
        final List<Line> lines = ladder.getLines();
        for (int i = 0; i < lines.size(); i++) {
            verify(ladderResult, lines.get(i), i);
        }
        return ladderResult;
    }

    private static void verify(final Map<Integer, Integer> ladderResult, final Line line, final int row) {

        for (int column = 0; column < line.getPoints().size(); column++) {
            final Point point = findPoint(ladderResult, line, row, column);
            ladderResult.put(column, point.move());
        }
    }

    private static Point findPoint(final Map<Integer, Integer> ladderResult, final Line line
            , final int row, final int column) {

        if (row == 0) {
            return getPoint(line, column);
        }
        return getPoint(line, ladderResult.get(column));
    }

    private static Point getPoint(final Line line, int point) {

        return line.getPoints().get(point);
    }

    public Map<String, String> getLadderResult() {

        return ladderResult;
    }

    public String findByName(final String key) {

        return this.ladderResult.get(key);
    }
}