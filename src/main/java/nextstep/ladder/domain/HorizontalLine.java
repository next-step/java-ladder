package nextstep.ladder.domain;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HorizontalLine {

    private final static ThreadLocalRandom random = ThreadLocalRandom.current();
    private final static int ZERO = 0;
    private final static int FIRST = 1;

    private final List<Boolean> points;

    public HorizontalLine(int countOfPerson) {
        this.points = IntStream.range(ZERO, countOfPerson)
                .mapToObj(point -> false)
                .collect(Collectors.toList());
    }

    public HorizontalLine generatePoint() {
        IntStream.range(FIRST, points.size())
                .mapToObj(index -> {
                    points.set(index, random.nextBoolean());
                    checkConnectLine(index);
                    return points.get(index);
                })
                .collect(Collectors.toList());
        return this;
    }

    private void checkConnectLine(int index) {
        if (points.get(index - 1).equals(true)) {
            points.set(index, false);
        }
    }

    public List<Boolean> points() {
        return points;
    }
}
