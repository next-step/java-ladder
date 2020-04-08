package ladder.domain;

import ladder.exception.LadderException;

public class Ladder {

    private static final String USER_AND_RESULT_COUNT_MATCH_ERR_MST =
            "참가자와 게임 결과의 수가 일치해야 합니다.";

    private final Lines lines;
    private final LadderPrize ladderPrize;

    public Ladder(Lines lines, LadderPrize ladderPrize) {
        validateUserAndResult(lines.getLines().get(0).getNodes().size(), ladderPrize);
        this.lines = lines;
        this.ladderPrize = ladderPrize;
    }

    public static Ladder of(final int startPointCount,
                            final int height,
                            final LadderPrize result) {
        Lines lines = Lines.of(startPointCount, height);

        return new Ladder(lines, result);
    }

    private void validateUserAndResult(final int startPointCount, final LadderPrize ladderPrize) {
        if (startPointCount != ladderPrize.size()) {
            throw new LadderException(USER_AND_RESULT_COUNT_MATCH_ERR_MST);
        }
    }

    public Node findLastNode(final int startNodeNumber) {
        return lines.move(startNodeNumber);
    }

    public Lines getLines() {
        return lines;
    }

    public LadderPrize getLadderPrize() {
        return ladderPrize;
    }
}
