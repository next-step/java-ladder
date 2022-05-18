package ladder.domain;

import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private static final Random RANDOM = new Random();
    public static final int START_INDEX = 1;
    public static final int GO_TO_PREVIOUS_INDEX = -1;

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line from(int countOfParticipants) {
        List<Boolean> points = new ArrayList<>(Collections.nCopies(countOfParticipants, false));

        IntStream.range(START_INDEX, countOfParticipants)
                .forEach(index -> {
                    boolean previousPoint = points.get(index + GO_TO_PREVIOUS_INDEX);
                    points.set(index, nextPoint(previousPoint));
                });
        return new Line(points);
    }

    private static boolean nextPoint(boolean previousPoint) {
        if (previousPoint) {
            return false;
        }
        return RANDOM.nextBoolean();
    }

    public List<Boolean> getPoints() {
        return List.copyOf(points); // 방어적 복사
    }
}
