package nextstep.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderLineGenerator {
    private static final Random LINE_GENERATOR = new Random();

    public static List<Boolean> generate(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> LINE_GENERATOR.nextBoolean())
                .collect(Collectors.toList());
    }

}
