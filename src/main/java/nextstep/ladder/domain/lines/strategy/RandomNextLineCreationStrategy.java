package nextstep.ladder.domain.lines.strategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Line;

public class RandomNextLineCreationStrategy implements NextLineCreationStrategy {

    @Override
    public Line createNextLine(Line beforLine, int height) {
        Random random = new Random();
        return new Line(createNextPoints(beforLine, height, random));
    }

    private List<Boolean> createNextPoints(Line beforLine, int height, Random random) {
        return IntStream.range(0, height)
                .mapToObj(beforLine::hasHorizontalLine)
                .map(hasHorizontalLine -> {
                    if (hasHorizontalLine) {
                        return false;
                    }
                    return random.nextBoolean();
                })
                .collect(Collectors.toList());
    }
}
