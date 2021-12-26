package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int INIT_INDEX = 0;

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public static Ladder of(int width, Height height, LineStrategy lineStrategy) {
        List<Line> ladder = IntStream.range(INIT_INDEX, height.getValue())
                                    .mapToObj(index -> Line.of(width, lineStrategy))
                                    .collect(Collectors.toList());
        return new Ladder(ladder);
    }

    public int discovery(int number) {
        AtomicInteger result = new AtomicInteger(number);
        ladder.forEach(line -> result.set(line.move(result.get())));
        return result.get();
    }
}
