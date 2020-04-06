package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final LadderLines lines;
    private final LadderGameRewords ladderGameRewords;

    private Ladder(final LadderLines lines, final LadderGameRewords ladderGameRewords) {
        validate(lines, ladderGameRewords);
        this.lines = lines;
        this.ladderGameRewords = ladderGameRewords;
    }

    private void validate(final LadderLines lines, final LadderGameRewords ladderGameRewords) {
        if (lines.getPoleCount() == ladderGameRewords.count()) {
            throw new IllegalArgumentException("Ladder pole size is not same as Ladder game rewords.");
        }
    }

    public static Ladder newInstance(final int poleCount, final int height, final String rewords) {
        return newInstance(poleCount, LadderHeight.newInstance(height), LadderGameRewords.newInstance(rewords));
    }

    public static Ladder newInstance(final int poleCount, final LadderHeight ladderHeight, final LadderGameRewords ladderGameRewords) {
        return new Ladder(LadderLines.newInstance(poleCount, ladderHeight), ladderGameRewords);
    }

    public int getPoleCount() {
        return lines.getPoleCount();
    }

    public LadderGameRewords proceedAll() {
        List<LadderGameReword> proceedResult = lines.proceedAll()
                .stream()
                .map(pole -> ladderGameRewords.getLadderGameReword(pole.getPolePosition()))
                .collect(Collectors.toList());
        return LadderGameRewords.newInstance(proceedResult);
    }
}
