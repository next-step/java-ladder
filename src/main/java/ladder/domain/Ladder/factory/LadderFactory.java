package ladder.domain.Ladder.factory;

import ladder.domain.Ladder.Line;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderFactory {

    private LadderFactory() {
    }

    public static List<Line> generateLines(int height, int countOfPerson) {
        return Stream.generate(() -> new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }
}
