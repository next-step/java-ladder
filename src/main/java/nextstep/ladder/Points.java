package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Points {
    public static final String POINTS_INVALID_VALUE_ERR_MSG = "Points의 값이 연속된 true일 수 없습니다.";
    private final List<Boolean> values;
    private final Random random = new Random();

    public Points(CountOfPerson countOfPerson) {
        this.values = new ArrayList<>(countOfPerson.value - 1);
        setPoints(countOfPerson);
        validatePoints();
    }

    private void setPoints(CountOfPerson countOfPerson) {
        values.add(random.nextBoolean());

        IntStream.range(1, countOfPerson.value - 1)
                .forEach(index -> {
                    if (values.get(index - 1)) {
                        values.add(false);
                        return;
                    }
                    values.add(random.nextBoolean());
                });
    }

    private void validatePoints() {
        boolean hasContinuousTrueValue = IntStream.range(0, values.size() - 1)
                .anyMatch(index -> values.get(index) && values.get(index + 1));

        if (hasContinuousTrueValue) {
            throw new IllegalStateException(POINTS_INVALID_VALUE_ERR_MSG);
        }
    }

    public int size() {
        return values.size();
    }
}
