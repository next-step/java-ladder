package ladder.helper;

import ladder.domain.ladder.LadderSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fixture {
    public static LadderSize ladderSize() {
        return new LadderSize(10, 10);
    }

    public static List<Boolean> generatedLines() {
        return new ArrayList<>(Arrays.asList(true, false, true, false, true, false, true, false, true, false));
    }
}
