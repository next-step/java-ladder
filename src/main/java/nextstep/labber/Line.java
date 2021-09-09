package nextstep.labber;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private static final int MIN_POINTS_SIZE = 0;
    private static final int LADDER_DIFFERENCES_VALUE = 1;

    private final List<Boolean> points;

    public Line(int participantsCount) {
        points = new ArrayList<>();
        IntStream.range(0, participantsCount - LADDER_DIFFERENCES_VALUE)
                .forEach(index -> {
                    points.add(createPoint());
                });
        points.add(false);
    }

    public Line(List<Boolean> points) {
        this.points = points;
    }

    protected boolean createPoint() {
        SecureRandom random = new SecureRandom();
        if (points.size() != MIN_POINTS_SIZE && pointsLastElement()) {
            return false;
        }
        return random.nextBoolean();
    }

    private Boolean pointsLastElement() {
        return this.points.get(this.points.size() - 1);
    }

    public Compass move(int index) {
        if (this.points.get(index)) {
            return Compass.RIGHT;
        }

        if (index > 0 && this.points.get(index - 1)) {
            return Compass.LEFT;
        }
        return Compass.DOWN;
    }

    public int size() {
        return this.points.size();
    }
}
