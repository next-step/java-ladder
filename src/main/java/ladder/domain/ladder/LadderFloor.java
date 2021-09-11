package ladder.domain.ladder;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class LadderFloor {
    private final List<Boolean> lines;

    public LadderFloor(List<Boolean> lines) {
        this.lines = lines;
    }

    public LadderFloor(final int countOfParticipants, final LadderLineGenerator ladderLineGenerator) {
        this(new LadderSize(countOfParticipants), ladderLineGenerator);
    }

    public LadderFloor(final LadderSize ladderSize, final LadderLineGenerator ladderLineGenerator) {
        this(generateLines(ladderSize.getMaxWidthPosition(), ladderLineGenerator));
    }

    public List<Boolean> getLines() {
        return lines;
    }

    static private List<Boolean> generateLines(final int maxLadderWidth, final LadderLineGenerator ladderLineGenerator) {
        List<Boolean> lines = new ArrayList<>(maxLadderWidth);
        boolean postLine = false;

        for (int i = 0; i < maxLadderWidth; i++) {
            postLine = ladderLineGenerator.generate(postLine);
            lines.add(postLine);
        }

        return lines;
    }
}
