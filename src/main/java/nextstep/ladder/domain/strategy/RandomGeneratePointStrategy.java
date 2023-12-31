package nextstep.ladder.domain.strategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomGeneratePointStrategy implements GeneratePointStrategy {

    public static final int MAX_PERSON_SIZE = 1;
    private Random random = new Random();
    private int count;

    public RandomGeneratePointStrategy(int count) {
        this.count = count;
    }

    @Override
    public List<Boolean> generate() {
        return Stream.iterate(random.nextBoolean(), this::hasLine)
                .limit(count - MAX_PERSON_SIZE)
                .collect(Collectors.toList());
    }

    private boolean hasLine(Boolean hasLine) {
        return !hasLine && random.nextBoolean();
    }
}
