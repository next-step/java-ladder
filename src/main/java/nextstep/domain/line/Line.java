package nextstep.domain.line;

import nextstep.generator.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(List<Boolean> points) {
        this.points = points.stream()
                        .map(Point::new)
                        .collect(Collectors.toList());
        checkValidPoints();
    }

    public Line(int playerCounts, RandomNumberGenerator randomNumberGenerator) {
        points = new ArrayList<>();
        for (int index = 0; index < playerCounts; index++) {
            points.add(createLine(index, randomNumberGenerator));
        }
        checkValidPoints();
    }

    private void checkValidPoints() {
        IntStream.range(0, this.points.size())
                .filter(index -> this.points.get(index).isConnected() && this.points.get(index + 1).isConnected())
                .findFirst()
                .ifPresent(index -> {throw new RuntimeException("연속으로 선이 이어지만 안됩니다.");});
    }

    private Point createLine(int index, RandomNumberGenerator randomNumberGenerator) {
        if(index == 0) {
            return new Point(randomNumberGenerator);
        }
        if(points.get(index -1).isConnected()) {
            return new Point(false);
        }
        return new Point(randomNumberGenerator);
    }

    public List<Point> getPoints() {
        return points;
    }
}
