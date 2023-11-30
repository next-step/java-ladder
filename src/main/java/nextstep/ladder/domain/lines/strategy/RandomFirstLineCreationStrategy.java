package nextstep.ladder.domain.lines.strategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Line;

public class RandomFirstLineCreationStrategy implements FirstLineCreationStrategy {

    @Override
    public Line createFirstLine(int height) {
        Random random = new Random();
        return new Line(createRandomPoints(height, random));
    }

    private List<Boolean> createRandomPoints(int height, Random random) {
        return IntStream.range(0, height)
                .mapToObj(endOfLadderIndex -> random.nextBoolean())
                .collect(Collectors.toList());
    }
}
