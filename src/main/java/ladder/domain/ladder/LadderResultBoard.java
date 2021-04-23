package ladder.domain.ladder;

import ladder.domain.participant.Participant;

import java.util.Map;

public final class LadderResultBoard {

    private final Map<Participant, String> resultBoard;

    private LadderResultBoard(final Map<Participant, String> resultBoard) {
        this.resultBoard = resultBoard;
    }

    public static final LadderResultBoard of(final Map<Participant, String> resultBoard) {
        return new LadderResultBoard(resultBoard);
    }
}
