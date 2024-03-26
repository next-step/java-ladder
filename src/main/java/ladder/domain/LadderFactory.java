package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

    public static Ladder generate(int participantCount, int height) {
        List<Line> lines = IntStream.range(0, height)
            .mapToObj(i -> LineFactory.generate(participantCount))
            .collect(Collectors.toList());
        return Ladder.from(lines);
    }
}
