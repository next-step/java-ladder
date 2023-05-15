package ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import ladder.util.PointStrategy;

public class Line {

    private static final String FIRST_TRUE_MSG = "첫 index 는 반드시 false 로 시작되어야합니다.";

    private static final String EMPTY_MSG = "사다리 포인트 정보가 없습니다.";

    private static final int SKIP_FIRST_INDEX = 1;

    private static final int MIN_PARTICIPANT_NUMBER = 1;

    private final List<Boolean> points;

    public Line(List<Boolean> points) {
        if (isEmptyArray(points)) {
            throw new IllegalArgumentException(EMPTY_MSG);
        }
        if (firstTrue(points)) {
            throw new IllegalArgumentException(FIRST_TRUE_MSG);
        }
        this.points = points;
    }

    private boolean firstTrue(List<Boolean> points) {
        return points.get(0);
    }

    private boolean isEmptyArray(List<Boolean> points) {
        return points == null || points.isEmpty();
    }

    public static Line lineOf(int countOfPerson, PointStrategy pointStrategy) {

        List<Boolean> points = new ArrayList<>();

        if(noParticipant(countOfPerson)) {
            return new Line(points);
        }

        points.add(pointStrategy.injectFalse());
        IntStream.range(SKIP_FIRST_INDEX, countOfPerson).forEachOrdered(index -> {
            final boolean previous = points.get(index - 1);
            points.add(previous ? pointStrategy.injectFalse()
                    : pointStrategy.point());
        });

        return new Line(points);
    }

    private static boolean noParticipant(int countOfPerson) {
        return countOfPerson < MIN_PARTICIPANT_NUMBER;
    }

    public int size() {
        return this.points.size();
    }

    public List<Boolean> immutableGet() {
        return unmodifiableList(this.points);
    }
}
