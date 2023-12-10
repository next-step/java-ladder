package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private static final int MIN_HEIGHT_OF_LADDER = 1;


    private final List<Line> values;

    public Lines(List<Line> values) {
        if (values.isEmpty()) {
            throw new IllegalArgumentException("최소 높이는 최소 " + MIN_HEIGHT_OF_LADDER + "이상이어야 합니다.");
        }
        this.values = values;
    }

    public static Lines of(int countOfPlayer, int maxHeightOfLadder) {
        List<Line> lines = IntStream.range(0, maxHeightOfLadder)
                .mapToObj(idx -> Line.of(countOfPlayer))
                .collect(Collectors.toList());

        return new Lines(lines);
    }

    public List<Line> values() {
        return new ArrayList<>(values);
    }

    public int finalPosition(final int startPosition) {
        int position = startPosition;

        for (Line line : values) {
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

        return position;
    }
}
