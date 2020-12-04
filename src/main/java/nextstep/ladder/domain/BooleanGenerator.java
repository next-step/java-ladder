package nextstep.ladder.domain;

import java.util.stream.IntStream;

@FunctionalInterface
public interface BooleanGenerator {
    Boolean nextBoolean();

    static Boolean[] generateBooleans(int size, BooleanGenerator booleanGenerator) {
        return IntStream
                .range(0, size)
                .mapToObj(index -> booleanGenerator.nextBoolean())
                .toArray(Boolean[]::new);
    }
}
