package ladder.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Collections.unmodifiableList;

public class LineRandomStrategy implements LineCreationStrategy {
    private static final int OFFSET_FOR_POINTS = 1;
    private static final Random random = new Random();

    @Override
    public List<Boolean> hasHorizontalLine(int countOfPersons) {
        return generateRandomBooleanList(getInitialSize(countOfPersons));
    }

    private static int getInitialSize(int countOfPersons) {
        return countOfPersons - OFFSET_FOR_POINTS;
    }

    private static List<Boolean> generateRandomBooleanList(int size) {
        List<Boolean> randomList = new ArrayList<>();
        boolean previousValue = false;

        for (int i = 0; i < size; i++) {
            boolean currentValue = generateRandomBoolean(previousValue);
            randomList.add(currentValue);
            previousValue = currentValue;
        }

        return unmodifiableList(randomList);
    }

    private static boolean generateRandomBoolean(boolean previousValue) {
        if (previousValue) {
            return false;
        }

        return random.nextBoolean();
    }
}
