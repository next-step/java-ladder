package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Line {
    public static final String POINTS_INVALID_VALUE_ERR_MSG = "Points의 값이 연속된 true일 수 없습니다.";
    private final List<Boolean> points;
    private final Random random = new Random();

    public Line(NumberOfParticipants numberOfParticipants) {
        this.points = new ArrayList<>(numberOfParticipants.value - 1);
        setPoints(numberOfParticipants);
        validatePoints();
    }

    private void setPoints(NumberOfParticipants numberOfParticipants) {
        points.add(random.nextBoolean());

        IntStream.range(1, numberOfParticipants.value - 1)
                .forEach(index -> {
                    if (points.get(index - 1)) {
                        points.add(false);
                        return;
                    }
                    points.add(random.nextBoolean());
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

    public void repeatAsPoints(Consumer<Boolean> renderPoints) {
        points.forEach(renderPoints);
    }
}
