package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MIN_LADDER_WIDTH = 2;
    private static final int MIN_LADDER_HEIGHT = 1;
    public static final int LADDER_HORIZON_WIDTH = 5;

    private final List<Line> lines;

    public Ladder(int ladderWidth, int ladderHeight) {
        this(generateLineList(ladderWidth, ladderHeight));
    }

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private static List<Line> generateLineList(int ladderWidth, int ladderHeight) {
        validateWidthHeight(ladderWidth, ladderHeight);
        return IntStream.range(0, ladderHeight)
                .mapToObj(i -> new Line(ladderWidth))
                .collect(Collectors.toList());
    }

    private static void validateWidthHeight(int ladderWidth, int ladderHeight) {
        if (ladderWidth < MIN_LADDER_WIDTH) {
            throw new IllegalArgumentException("사다리의 너비는 최소 " + MIN_LADDER_WIDTH + " 이상이어야 합니다.");
        }
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 최소 " + MIN_LADDER_HEIGHT + " 이상이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getExitNumber(int entranceNumber) {
        int exitNumber = entranceNumber;
        for (Line line : lines) {
            exitNumber = line.getLinkPointIndex(exitNumber);
        }
        return exitNumber;
    }
}
