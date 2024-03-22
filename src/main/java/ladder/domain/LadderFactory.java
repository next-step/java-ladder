package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {

    public static Ladder generate(int participants, int height) {
        List<Line> lines = IntStream.range(0, height)
            .mapToObj(i -> LineFactory.generate(participants))
            .collect(Collectors.toList());
        return Ladder.of(lines);
    }
}
