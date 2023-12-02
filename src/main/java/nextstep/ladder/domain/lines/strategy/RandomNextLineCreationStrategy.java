package nextstep.ladder.domain.lines.strategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

public class RandomNextLineCreationStrategy implements NextLineCreationStrategy {

    @Override
    public Line createNextLine(Line beforeLine, int height) {
        Random random = new Random();
        return Line.createLine2WithPoints(createNextPoints(beforeLine, height, random));
    }

    private List<Point> createNextPoints(Line beforeLine, int height, Random random) {
        return IntStream.range(0, height)
                .mapToObj(beforeLine::horizontalLine)
                .collect(Collectors.toList());
    }
}
