package nextstep.ladder.domain.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderUtil {
    private static final Random random = new Random();

    private LadderUtil() {
    }

    public static List<Boolean> makeLadderLine(int participantsCount) {
        boolean status = false;
        final List<Boolean> ladderRow = new ArrayList<>();
        ladderRow.add(status);

        for (int i = 0; i < participantsCount - 1; i++) {
            status = makeNextLine(status);
            ladderRow.add(status);
        }

        return ladderRow;
    }

    private static boolean makeNextLine(boolean status) {
        if (status) {
            return false;
        }

        return random.nextBoolean();
    }
}
