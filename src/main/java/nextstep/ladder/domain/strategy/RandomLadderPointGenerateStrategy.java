package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.GenerateLadderPointStrategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLadderPointGenerateStrategy implements GenerateLadderPointStrategy {
    private static final Random RANDOM = new Random();
    private boolean wasPrevious;

    @Override
    public List<Boolean> generate(int size) {
        return IntStream.range(0, size - 1)
                .mapToObj(i -> generatePoint())
                .collect(Collectors.toList());
    }

    private boolean generatePoint() {
        boolean point = !wasPrevious && RANDOM.nextBoolean();
        this.wasPrevious = point;

        return point;
    }

}
