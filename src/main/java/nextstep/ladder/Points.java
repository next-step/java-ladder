package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Points {
    public static final String POINTS_INVALID_VALUE_ERR_MSG = "Points의 값이 연속으로 true일 수 없습니다.";
    private final List<Boolean> values;
    private final Random random = new Random();

    public Points(CountOfPerson countOfPerson) {
        this.values = new ArrayList<>(countOfPerson.value - 1);
        setPoints(countOfPerson);
        validatePoints();
    }

    private void setPoints(CountOfPerson countOfPerson) {
        values.add(random.nextBoolean());
        for (int j = 1; j < countOfPerson.value - 1; j++) {
            if (values.get(j - 1)) {
                values.add(false);
                continue;
            }
            values.add(random.nextBoolean());
        }
    }

    private void validatePoints() {
        for (int i = 0; i < values.size() - 1; i++) {
            if (values.get(i) && values.get(i + 1)) {
                throw new IllegalStateException(POINTS_INVALID_VALUE_ERR_MSG);
            }
        }
    }

    public int size() {
        return values.size();
    }
}
