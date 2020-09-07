package nextstep.entity;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private static final boolean FIRST_PEDAL = false;
    private static final int START_INDEX = 0;
    private static final Random RANDOM = new Random();
    private final List<Point> points;

    public Line(int personnel) {
        AtomicBoolean previousHasPedal = new AtomicBoolean(FIRST_PEDAL);
        this.points = IntStream.range(START_INDEX, personnel).mapToObj(index -> {
            if (index == START_INDEX) {
                return new Point(FIRST_PEDAL);
            }
            boolean currentHasPedal = this.generatePedal(previousHasPedal.get());
            previousHasPedal.set(currentHasPedal);
            return new Point(currentHasPedal);
        }).collect(Collectors.toList());
    }

    public List<Boolean> getPedalsStatus() {
        return this.points.stream()
                .map(Point::isPedalExist)
                .collect(Collectors.toList());
    }

    private boolean generatePedal(boolean hasPedal) {
        return !hasPedal && RANDOM.nextBoolean();
    }
}
