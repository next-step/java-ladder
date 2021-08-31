package nextstep.laddergame.domain;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = Collections.unmodifiableList(lines);
    }

    public static Ladder of(PlayerCount playerCount, int height) {
        return new Ladder(createLines(playerCount, height));
    }

    private static List<Line> createLines(PlayerCount playerCount, int height) {
        return Stream.generate(() -> Line.of(RandomLineConnectStrategy.of(new Random(), playerCount)))
                .limit(height)
                .collect(Collectors.toList());
    }

    public int height() {
        return lines.size();
    }
}
