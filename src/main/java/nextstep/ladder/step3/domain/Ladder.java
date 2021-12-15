package nextstep.ladder.step3.domain;

import java.util.ArrayList;
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

    public static Ladder of(int width, Height height) {
        RandomLineStrategy randomLineStrategy = new RandomLineStrategy();

        List<Line> lines = IntStream.range(0, height.getHeight())
            .mapToObj((i) -> Line.of(width, randomLineStrategy))
            .collect(Collectors.toCollection(ArrayList::new));
        return new Ladder(lines);
    }

    public static Ladder of(int width, Height height, LineStrategy lineStrategy) {
        List<Line> lines = IntStream.range(0, height.getHeight())
            .mapToObj((i) -> Line.of(width, lineStrategy))
            .collect(Collectors.toCollection(ArrayList::new));
        return new Ladder(lines);
    }

}
