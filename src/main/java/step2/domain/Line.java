package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(int numOfUsers) {
        points.add(ThreadLocalRandom.current().nextBoolean());
        IntStream.range(1, numOfUsers - 1)
                .mapToObj(i -> !points.get(i - 1))
                .forEach(points::add);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
