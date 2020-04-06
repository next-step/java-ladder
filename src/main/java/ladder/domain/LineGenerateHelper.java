package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LineGenerateHelper {
    private static final Random random = new Random();

    private LineGenerateHelper() { }

    public static List<Boolean> generate(int playerCount) {
        final List<Boolean> lines = init();
        for (int i = lines.size(); i < playerCount; i++) {
            boolean prevLine = lines.get(i - 1);
            lines.add(drawLine(prevLine));
        }
        return lines;
    }

    private static List<Boolean> init() {
        return new ArrayList<>(Arrays.asList(Boolean.FALSE));
    }

    private static Boolean drawLine(final boolean isExistPrev) {
        if (isExistPrev) {
            return Boolean.FALSE;
        }
        return random.nextBoolean();
    }
}
