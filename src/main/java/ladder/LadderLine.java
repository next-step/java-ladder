package ladder;

import static util.Preconditions.checkArgument;

public class LadderLine {
    public static final String PERSON_COUNT_MUST_MORE_THEN_ONE = "person count must more then one";

    private LadderLine() {
    }
    
    public static LadderLine of(final int personCount) {
        checkArgument(personCount >= 1, PERSON_COUNT_MUST_MORE_THEN_ONE);
        return new LadderLine();
    }
}
