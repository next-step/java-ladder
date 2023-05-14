package nextstep.laddergame.domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final int ladderHeight, final int participantsCount) {
        this.checkHeight(ladderHeight);

        this.lines = IntStream.range(0, ladderHeight)
                .mapToObj(height -> new Line(participantsCount))
                .collect(Collectors.toList());
    }

    private void checkHeight(int ladderHeight) {
        if (ladderHeight == 0) {
            throw new IllegalArgumentException("사다리 높이는 1칸 이상이여야합니다.");
        }
    }
}
