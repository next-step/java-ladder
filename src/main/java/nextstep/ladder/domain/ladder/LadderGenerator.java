package nextstep.ladder.domain.ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LadderGenerator {

    private static final Random RANDOM = new Random();

    public static Map<Ladder, Boolean> createLadders(int width, int height) {
        Map<Ladder, Boolean> map = new HashMap<>();

        for (int i = 0; i < height; i++) {
            boolean previousHasLine = false;
            for (int j = 0; j < width; j++) {
                if (j + 1 == width) {
                    map.put(new Ladder(i, j), false);
                    continue;
                }
                boolean currentHasLine = createHasHorizontalLine(previousHasLine);
                map.put(new Ladder(i, j), currentHasLine);
                previousHasLine = currentHasLine;
            }
        }

        return map;
    }

    private static boolean createHasHorizontalLine(Boolean previousValue) {
        if (previousValue) {
            return false;
        }

        return RANDOM.nextBoolean();
    }
}
