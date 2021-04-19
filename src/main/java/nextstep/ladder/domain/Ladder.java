package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static nextstep.ladder.util.BinaryOperators.nope;

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

    public List<Integer> allResult() {
        return IntStream.range(0, lines.get(0).size())
                .mapToObj(this::result)
                .collect(Collectors.toList());
    }

    private int result(int position) {
        return lines.stream()
                .reduce(position,
                        (startPosition, line) -> line.move(startPosition),
                        nope());
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
