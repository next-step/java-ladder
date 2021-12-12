package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public static Ladder of(int width, Height height, LineStrategy lineStrategy) {
        List<Line> ladder = IntStream.range(0, height.getValue())
                                    .mapToObj((index) -> Line.of(width, lineStrategy))
                                    .collect(Collectors.toList());
        return new Ladder(ladder);
    }
}
