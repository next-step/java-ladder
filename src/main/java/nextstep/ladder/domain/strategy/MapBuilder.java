package nextstep.ladder.domain.strategy;

import java.util.Random;
import java.util.StringJoiner;

public class MapBuilder {
    public static String createRandomBridge(int countOfPerson) {
        int lastIndex = Integer.MAX_VALUE;
        StringJoiner stringJoiner = new StringJoiner(",");

        for (int i = 0; i < countOfPerson - 1; i++) {
            lastIndex = markPoint(stringJoiner, lastIndex, i);
        }

        if (lastIndex == Integer.MAX_VALUE) {
            stringJoiner.add(String.valueOf(countOfPerson - 2));
        }

        return stringJoiner.toString().trim();
    }

    private static int markPoint(StringJoiner stringJoiner, int lastIndex, int currentIndex) {
        Random random = new Random();
        if (Math.abs(lastIndex - currentIndex) >= 2 && random.nextBoolean()) {
            stringJoiner.add(String.valueOf(currentIndex));
            return currentIndex;
        }
        return lastIndex;
    }
}
