package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> ladder;


    public Ladder(int height, int countOfPerson) {
        this(generateLines(height, countOfPerson));
    }

    private static List<Line> generateLines(int height, int countOfPerson) {
        return Stream.generate(() -> new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    @Override
    public String toString() {
        return ladder.stream().map(line -> " ".repeat(5) + line.toString() + "\n").collect(Collectors.joining());
    }
}
