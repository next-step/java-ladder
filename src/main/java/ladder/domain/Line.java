package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_NUMBER_UPPER_BOUND = 2;
    private static final int CONSTANT_TO_CONVERT_COUNT_OF_PERSON_TO_COUNT_OF_LINE = 1;

    private final List<Boolean> line = new ArrayList<>();

    public Line(int countOfPerson) {
        line.add(0, createTrueOrFalse());
        for (int i = 1; i < countOfPerson - CONSTANT_TO_CONVERT_COUNT_OF_PERSON_TO_COUNT_OF_LINE; i++) {
            addValueComparedToPreviousValue(line.get(i - 1));
        }
    }

    Boolean addValueComparedToPreviousValue(Boolean previousValue) {
        if (previousValue == false) {
            Boolean currentValue = createTrueOrFalse();
            line.add(currentValue);
            return currentValue;
        }
        line.add(false);
        return false;
    }

    static boolean createTrueOrFalse() {
        return RANDOM.nextInt(RANDOM_NUMBER_UPPER_BOUND) == 1;
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(line);
    }

    @Override
    public String toString() {
        return line.toString();
    }
}
