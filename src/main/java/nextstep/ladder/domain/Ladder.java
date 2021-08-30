package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_VALUE = 1;
    private final List<Line> lines;

    public Ladder(final int width, final int ladderHeight) {
        if (width < MIN_VALUE || ladderHeight < MIN_VALUE) {
            throw new IllegalArgumentException("width 와 height 는 " + MIN_VALUE + "이상이어야 합니다.");
        }
        this.lines = Collections.unmodifiableList(createLines(width, ladderHeight));
    }

    private List<Line> createLines(final int width, final int ladderHeight) {
        return IntStream.range(0, ladderHeight)
                .mapToObj(index -> new Line(width))
                .collect(Collectors.toList());
    }

    public List<Line> valueOfLines() {
        return lines;
    }

}
