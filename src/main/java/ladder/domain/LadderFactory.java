package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderFactory {

    public static Ladder generate(int participantCount, int height) {
        List<Line> lines = Stream.generate(() -> LineFactory.generate(participantCount))
            .limit(height)
            .collect(Collectors.toList());
        return Ladder.from(lines);
    }
}
