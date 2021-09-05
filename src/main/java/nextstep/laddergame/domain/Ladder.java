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

    public static Ladder of(Players players, LadderHeights ladderHeights) {
        return new Ladder(createLines(players.size(), ladderHeights));
    }

    private static List<Line> createLines(int countOfPlayer, LadderHeights ladderHeights) {
        return Stream.generate(() -> Line.of(new RandomLineConnectStrategy(new Random(), countOfPlayer)))
                .limit(ladderHeights.getHeights())
                .collect(Collectors.toList());
    }

    public int height() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
