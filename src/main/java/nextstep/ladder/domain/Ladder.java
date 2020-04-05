package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    public static final String LADDER_HEIGHT_ERROR = "사다리 높이는 0보다 커야합니다.";
    private static final int MIN_LADDER_HEIGHT = 1;
    private List<Line> lines;

    public Ladder(List<Line> lines) {
        assertLadderHeight(lines.size());
        this.lines = lines;
    }

    public Ladder(int participantCount, int height) {
        this(createLadder(participantCount, height));
    }

    private static List<Line> createLadder(int participantCount, int height) {
        List<Line> lines = Stream
                .generate(() -> new Line(participantCount))
                .limit(height)
                .collect(Collectors.toList());

        return lines;
    }

    private void assertLadderHeight(int height) {
        if(height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(LADDER_HEIGHT_ERROR);
        }
    }

    public int getWidth() {
        Line firstLine = lines.get(0);
        List<Point> points = firstLine.getValue();

        return points.size();
    }

    public int getHeight() {
        return lines.size();
    }

    public List<Line> getValue() {
        return lines;
    }
}
