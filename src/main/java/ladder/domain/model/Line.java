package ladder.domain.model;

import ladder.domain.model.strategy.ConnectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson - 1)
                .forEach(count -> {
                    if (count == 0 || !points.get(count - 1)) {
                        connectLine(() -> RANDOM.nextBoolean());
                        return;
                    }
                    connectLine(() -> false);
                });
    }

    public List<Boolean> getLine() {
        return points;
    }

    public void connectLine(ConnectionStrategy connectionStrategy) {
        if (connectionStrategy.isConnection()) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }
}
