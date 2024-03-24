package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    public static final int MIN_LENGTH = 3;
    private static final String OVERLAP_EXCEPTION_MESSAGE = "가로 라인은 겹쳐질 수 없습니다";
    private static final String PARTICIPANT_COLUMN_TRUE_EXCEPTION_MESSAGE = "참가자가 타고 내려갈 열은 True여선 안 됩니다";
    private static final String MIN_LENGTH_EXCEPTION_MESSAGE =
        "사다리 열은 " + MIN_LENGTH + "개 이상 있어야 합니다";

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line from(List<Boolean> points) {
        validateNotEmpty(points);
        validateNotOverlap(points);
        validateParticipantColumnFalse(points);
        List<Boolean> unmodifiablePoints = Collections.unmodifiableList(points);
        return new Line(unmodifiablePoints);
    }

    private static void validateNotEmpty(List<Boolean> points) {
        if (points.size() < MIN_LENGTH) {
            throw new IllegalArgumentException(MIN_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNotOverlap(List<Boolean> points) {
        IntStream.range(0, points.size() - 2)
            .forEach(i -> validateNotOverlap(points, i));
    }

    private static void validateNotOverlap(List<Boolean> points, int idx) {
        if (points.get(idx) && points.get(idx + 2)) {
            throw new IllegalArgumentException(OVERLAP_EXCEPTION_MESSAGE);
        }
    }

    private static void validateParticipantColumnFalse(List<Boolean> points) {
        boolean anyParticipantColumnTrue = IntStream.range(0, points.size())
            .filter(i -> i % 2 == 0)
            .mapToObj(points::get)
            .anyMatch(p -> p);
        if (anyParticipantColumnTrue) {
            throw new IllegalArgumentException(PARTICIPANT_COLUMN_TRUE_EXCEPTION_MESSAGE);
        }
    }

    public List<Boolean> points() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Line{" +
            "points=" + points +
            '}';
    }
}
