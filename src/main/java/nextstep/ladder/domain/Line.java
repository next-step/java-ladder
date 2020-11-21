package nextstep.ladder.domain;

import nextstep.ladder.util.pointsgenerator.HalfRandomPointsGenerator;
import nextstep.ladder.util.pointsgenerator.PointsGenerator;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Line {
    public static final String POINTS_INVALID_VALUE_ERR_MSG = "points의 값이 연속된 true일 수 없습니다.";
    private final List<Boolean> points;

    private Line(NumberOfParticipants numberOfParticipants, PointsGenerator pointsGenerator) {
        points = pointsGenerator.getPoints(numberOfParticipants.getPointsSize());
        validatePoints();
    }

    private Line(NumberOfParticipants numberOfParticipants) {
        this(numberOfParticipants, HalfRandomPointsGenerator.getInstance());
    }

    public static Line from(NumberOfParticipants numberOfParticipants) {
        return new Line(numberOfParticipants);
    }

    public static Line of(NumberOfParticipants numberOfParticipants, PointsGenerator pointsGenerator) {
        return new Line(numberOfParticipants, pointsGenerator);
    }

    public static Line from(Participants participants) {
        return new Line(participants.getNumberOfParticipants());
    }

    private void validatePoints() {
        boolean hasContinuousTrueValue = IntStream.range(0, points.size() - 1)
                .anyMatch(index -> points.get(index) && points.get(index + 1));

        if (hasContinuousTrueValue) {
            throw new IllegalStateException(POINTS_INVALID_VALUE_ERR_MSG);
        }
    }

    public int size() {
        return points.size();
    }

    public void pointsForEach(Consumer<Boolean> renderPoint) {
        points.forEach(renderPoint);
    }
}
