package ladder.model;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class LadderLineGeneratorFactory {
    private static final Map<Boolean, LadderLinesGenerator> LADDER_LINES_GENERATORS = new HashMap<>();

    static {
        LADDER_LINES_GENERATORS.put(TRUE, new NarrowLadderLinesGenerator());
        LADDER_LINES_GENERATORS.put(FALSE, new WideLadderLinesGenerator());
    }

    public static LadderLinesGenerator findGenerator(int ladderLineCount, int pointCount) {
        boolean isNarrowLadder = ladderLineCount >= pointCount;
        return LADDER_LINES_GENERATORS.get(isNarrowLadder);
    }
}
