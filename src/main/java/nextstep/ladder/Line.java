package nextstep.ladder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points;

    public Line(int playerCount) {
        this.points = IntStream.range(1, playerCount)
                .mapToObj(it -> new Random().nextBoolean())
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
