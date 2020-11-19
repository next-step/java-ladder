package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    public static final String POINTS_INVALID_VALUE_ERR_MSG = "Points의 값이 연속된 true일 수 없습니다.";
    private final List<Boolean> points;
    private final Random random = new Random();

    public Line(CountOfPerson countOfPerson) {
        this.points = new ArrayList<>(countOfPerson.value - 1);
        setPoints(countOfPerson);
        validatePoints();
    }

    private void setPoints(CountOfPerson countOfPerson) {
        points.add(random.nextBoolean());

        IntStream.range(1, countOfPerson.value - 1)
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
}
