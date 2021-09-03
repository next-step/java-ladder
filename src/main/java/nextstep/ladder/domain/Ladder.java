package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_VALUE = 1;
    private static final String CREATE_LADDER_ERROR = "width 와 height 는 " + MIN_VALUE + "이상이어야 합니다.";

    private final List<Line> lines;

    public Ladder(final LadderInfo ladderInfo, final PointCreator pointCreator) {
        if (!ladderInfo.isRightLadderInfo(MIN_VALUE)) {
            throw new IllegalArgumentException(CREATE_LADDER_ERROR + ladderInfo);
        }
        this.lines = Collections.unmodifiableList(createLines(ladderInfo, pointCreator));
    }

    public int climbLadder(Location location) {
        for (Line line : this.lines) {
            location = location.move(line);
        }
        return location.getLocation();
    }

    private List<Line> createLines(final LadderInfo ladderInfo, final PointCreator pointCreator) {
        return IntStream.range(0, ladderInfo.getHeight())
                .mapToObj(index -> new Line(ladderInfo.getWidth(), pointCreator))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }

}
