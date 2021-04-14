package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(Height height, Players players) {
        List<Line> lines = Stream.generate(() -> generateLine(players.countOfPerson()))
                .limit(height.value())
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

    private static Line generateLine(int countOfPerson) {
        return Line.init(countOfPerson);
    }

    public int height() {
        return lines.size();
    }
}
