package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final int height;
    private final int width;
    public Ladder(int participantNum, int ladderHeight) {
        this.width = participantNum;
        this.height = ladderHeight;
    }

    public List<Line> create() {
        return IntStream.rangeClosed(1, height)
                .mapToObj(i -> new Line(width))
                .collect(Collectors.toList());
    }
}
