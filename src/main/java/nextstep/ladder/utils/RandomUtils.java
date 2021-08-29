package nextstep.ladder.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static List<Boolean> getBooleanList(int countOfPlayer) {
        List<Boolean> booleans = new ArrayList<>();

        booleans.add(false);
        for (int i = 1; i < countOfPlayer; i++) {
            if (booleans.get(i - 1)) {
                booleans.add(false);
                continue;
            }
            booleans.add(getBoolean());
        }
        return booleans;
    }

    private static Boolean getBoolean() {
        return RANDOM.nextBoolean();
    }
}
