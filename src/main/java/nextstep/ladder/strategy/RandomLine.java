package nextstep.ladder.strategy;

import nextstep.ladder.domain.Line;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLine implements LineCreatableStrategy {
    private final Random random = new Random();

    @Override
    public Line create(final int countOfPerson) {
        AtomicReference<Boolean> previous = new AtomicReference<>(false);
        int sizePoints = countOfPerson - 1;
        List<Boolean> points = IntStream.range(0, sizePoints)
                .mapToObj(i -> isTrueContinuous(random.nextBoolean(), previous))
                .collect(Collectors.toList());
        return new Line(points);
    }

    private static Boolean isTrueContinuous(Boolean current, final AtomicReference<Boolean> previous) {
        if (Boolean.TRUE.equals(previous.get()) && current) {
            current = false;
        }
        previous.set(current);
        return current;
    }
}
