package nextstep.ladder.domain.lines.strategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

public class RandomFirstLineCreationStrategy implements FirstLineCreationStrategy {

    @Override
    public Line createFirstLine(int height) {
        Random random = new Random();
        return Line.createLine2WithPoints(createRandomPoints(height, random));
    }

    private List<Point> createRandomPoints(int height, Random random) {
        return IntStream.range(0, height)
                .mapToObj(endOfLadderIndex -> Point.valueOf(random.nextBoolean()))
                .collect(Collectors.toList());
    }
}
