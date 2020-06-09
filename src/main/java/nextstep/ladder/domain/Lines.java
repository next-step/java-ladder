package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lines {
    private final List<Line> lines;

    public Lines(int countOfPerson, int height, MovementGenerator movementGenerator) {
        this.lines = this.generateLines(countOfPerson, height, movementGenerator);
    }

    private List<Line> generateLines(int countOfPerson, int height, MovementGenerator movementGenerator) {
        return Stream.generate(() -> new Line(countOfPerson, movementGenerator))
                .limit(height)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    public int move(int bridgeIndex) {
        for (int i = 0; i < this.lines.size(); i++) {
            Line line = this.lines.get(i);
            bridgeIndex = line.move(bridgeIndex);
        }
        return bridgeIndex;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
