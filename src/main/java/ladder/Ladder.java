package ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder from(Height height, Players players) {
        return new Ladder(IntStream
                .range(0, height.getHeight())
                .mapToObj((integer) -> Line.from(players.numberOfPlayers()))
                .collect(Collectors.toList()));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
