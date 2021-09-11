package ladder.domain.ladder;

import java.util.*;

public final class LadderFloor {
    private final List<Boolean> lines;

    public LadderFloor(final int countOfParticipants, final LadderLineGenerator ladderLineGenerator) {
        this(new LadderSize(countOfParticipants), ladderLineGenerator);
    }

    public LadderFloor(final LadderSize ladderSize, final LadderLineGenerator ladderLineGenerator) {
        lines = generateLines(ladderSize.getMaxWidthPosition(), ladderLineGenerator);
    }

    public List<Boolean> getLines() {
        return lines;
    }

    private List<Boolean> generateLines(final int maxLadderWidth, final LadderLineGenerator ladderLineGenerator) {
        return ladderLineGenerator.generate(maxLadderWidth);
    }
}
