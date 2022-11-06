package nextstep.ladder;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineFactory {
    public static Line randomLine(int countOfPerson) {
        Random random = new Random();
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
