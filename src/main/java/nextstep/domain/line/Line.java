package nextstep.domain.line;

import nextstep.generator.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(int playerCounts, RandomNumberGenerator randomNumberGenerator) {
        points = IntStream
                .range(0, playerCounts - 1)
                .mapToObj(point -> new Point(randomNumberGenerator))
                .collect(Collectors.toList());
        checkValidPoints();
    }

    private void checkValidPoints() {
        IntStream.range(0, this.points.size() - 1)
                .filter(index -> this.points.get(index).isConnected() && this.points.get(index + 1).isConnected())
                .findFirst()
                .ifPresent(index -> new RuntimeException("연속으로 선이 이어지만 안됩니다."));
    }
}
