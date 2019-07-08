package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LadderFactory {
    private LadderFactory() {
    }

    public static Ladder create(final List<String> names, final int height) {
        final int size = names.size();
        final List<Line> lines = IntStream.range(0, height)
                .mapToObj(number -> LineFactory.createLine(size))
                .collect(Collectors.toList());
        return Ladder.from(lines);
    }
}
