package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static util.Preconditions.checkArgument;

public class Ladder {
    private static final int MINIMUM_LADDER_HEIGHT = 1;
    public static String LADDER_HEIGHT_MUST_MORE_THEN_ONE = "ladder height must more then one";
    
    private final List<LadderLine> ladderLines;

    public Ladder(final List<LadderLine> ladderLines) {
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public static Ladder of(final int userCount, final int ladderHeight) {
        checkArgument(ladderHeight >= MINIMUM_LADDER_HEIGHT, LADDER_HEIGHT_MUST_MORE_THEN_ONE);
        return Stream.generate(() -> LadderLine.of(userCount))
                .limit(ladderHeight)
                .collect(collectingAndThen(toList(), Ladder::new));
    }

    public int size() {
        return ladderLines.size();
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}
