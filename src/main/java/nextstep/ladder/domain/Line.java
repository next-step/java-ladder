package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Line {
    public static final String POINTS_INVALID_VALUE_ERR_MSG = "Points의 값이 연속된 true일 수 없습니다.";
    private final List<Boolean> points;
    private final Random random = new Random();

    private Line(NumberOfParticipants numberOfParticipants) {
        points = new ArrayList<>(numberOfParticipants.getPointsSize());
        setPoints(numberOfParticipants);
        validatePoints();
    }

    public static Line from(NumberOfParticipants numberOfParticipants) {
        return new Line(numberOfParticipants);
    }

    public static Line from(Participants participants) {
        return new Line(participants.getNumberOfParticipants());
    }

    private void setPoints(NumberOfParticipants numberOfParticipants) {
        points.add(random.nextBoolean());

        IntStream.range(1, numberOfParticipants.getPointsSize())
                .forEach(index -> {
                    Boolean prevPoint = points.get(index - 1);
                    points.add(prevPoint ? false : random.nextBoolean());
                });
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

    public void pointsForEach(Consumer<Boolean> renderPoint, Runnable renderLadderStick) {
        points.forEach(point -> {
            renderPoint.accept(point);
            renderLadderStick.run();
        });
    }
}
