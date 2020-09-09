package nextstep.entity;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final boolean NO_PEDAL = false;
    private static final int START_INDEX = 0;
    private static final Random RANDOM = new Random();
    private final List<Point> points;

    private Line(int personnel) {
        AtomicBoolean previousRightPedal = new AtomicBoolean(NO_PEDAL);
        this.points = IntStream.range(START_INDEX, personnel).mapToObj(index -> {
            boolean leftPedal = index == START_INDEX ? NO_PEDAL : previousRightPedal.get();
            boolean rightPedal = isLastPoint(index, personnel) ? NO_PEDAL : this.generatePedal(leftPedal);
            previousRightPedal.set(rightPedal);
            return Point.of(leftPedal, rightPedal);
        }).collect(Collectors.toList());
    }

    private boolean isLastPoint(int currentIndex, int personnel) {
        return currentIndex == personnel - 1;
    }

    public List<Boolean> getPedalsStatus() {
        return this.points.stream()
                .map(Point::hasLeftPedal)
                .collect(Collectors.toList());
    }

    private boolean generatePedal(boolean hasPedal) {
        return !hasPedal && RANDOM.nextBoolean();
    }

    public int play(int index) {
        Point point = points.get(index);
        return point.play(index);
    }

    public static Line of(int personnel) {
        return new Line(personnel);
    }
}
