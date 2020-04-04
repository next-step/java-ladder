package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    public static final String LADDER_HEIGHT_ERROR = "사다리 높이는 1보다 커야합니다.";

    private List<Line> lines;
    public Ladder(List<Line> lines) {
        assertLadderHeight(lines.size());
        this.lines = lines;
    }

    public Ladder(int pointCount, int height) {
        this(createLadder(pointCount, height));
    }

    private static List<Line> createLadder(int pointCount, int height) {
        List<Line> lines = Stream
                .generate(() -> new Line(pointCount))
                .limit(height)
                .collect(Collectors.toList());

        return lines;
    }

    private void assertLadderHeight(int height) {
        if(height < 1) {
            throw new IllegalArgumentException(LADDER_HEIGHT_ERROR);
        }
    }

    public int getWidth() {
        return lines.get(0).getValue().size();
    }

    public int getHeight() {
        return lines.size();
    }
}
