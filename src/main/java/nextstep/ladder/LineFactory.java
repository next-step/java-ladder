package nextstep.ladder;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineFactory {
    private static final Random random = new Random();

    public static Line randomLine(int countOfPerson) {
        return new Line(Stream.generate(random::nextBoolean)
                .flatMap(connected -> {
                    if (connected) {
                        return Stream.of(true, false);
                    }
                    return Stream.of(false);
                })
                .limit(countOfPerson - 1)
                .collect(Collectors.toList()));
    }
}
