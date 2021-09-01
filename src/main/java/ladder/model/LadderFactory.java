package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderFactory {
    public static Ladder create(int width, int height, MoveStrategy moveStrategy) {
        return new Ladder(makeLine(width, height, moveStrategy));
    }

    private static List<Line> makeLine(int width, int height, MoveStrategy moveStrategy) {
        return IntStream.range(0, height)
                .mapToObj((num) -> moveStrategy.generate(width))
                .map(Line::of)
                .collect(Collectors.toList());
    }

}
