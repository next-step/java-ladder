package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private static final int START_INDEX = 0;
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Height height, Players players) {
        List<Line> lines = new ArrayList<>();
        IntStream.range(START_INDEX, height.getSize())
                .forEach(x -> lines.add(new Line(players.count())));
        return new Ladder(lines);
    }

    public static Ladder of(List<Line> lines) {
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Location climb(Location location) {
        final Location[] nextLocation = {new Location(location.getLocation())};
        this.lines.forEach(line ->
            nextLocation[0] = line.move(nextLocation[0])
        );
        return nextLocation[0];
    }
}
