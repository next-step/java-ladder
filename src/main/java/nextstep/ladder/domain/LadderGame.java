package nextstep.ladder.domain;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-28 16:07
 */
public final class LadderGame {

    private final LadderRequireElement ladderRequireElement;
    private final Ladder ladder;

    public LadderGame(LadderRequireElement ladderRequireElement, Ladder ladder) {
        this.ladderRequireElement = ladderRequireElement;
        this.ladder = ladder;
    }

    public List<String> getParticipant() {
        return this.ladderRequireElement.getParticipant();
    }

    public List<String> getExecutionResult() {
        return this.ladderRequireElement.getExecutionResult();
    }

    public List<LadderLine> getLadderLines() {
        return this.ladder.getLadderLines();
    }

    public LadderResult getLadderResult() {
        return new LadderResult(ladder, ladderRequireElement);
    }
}
