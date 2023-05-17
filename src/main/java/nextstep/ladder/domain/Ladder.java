package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final People people;
    private final List<Line> lines;

    public Ladder(People people, int height) {
        this.people = people;
        this.lines = generateLadder(height);
    }

    private List<Line> generateLadder(int height) {
        return Stream.generate(() -> new Line(people.value().size()))
                .limit(height)
                .collect(Collectors.toList());
    }

    public People people() {
        return people;
    }

    public List<Line> lines() {
        return lines.stream().collect(Collectors.toUnmodifiableList());
    }
}
