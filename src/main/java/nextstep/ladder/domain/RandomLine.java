package nextstep.ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLine {
    private static final Random random = new Random();

    public static List<Point> makeRandomLine(int numberOfParticipants) {
        List<Point> points = Stream.iterate(new Point(random.nextBoolean()), bool -> {
                    if (bool.getPoint()) {
                        return new Point(false);
                    }
                    return new Point(random.nextBoolean());
                })
                .limit(numberOfParticipants - 1)
                .collect(Collectors.toList());
        return points;
    }
}
