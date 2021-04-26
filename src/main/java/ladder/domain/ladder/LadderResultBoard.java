package ladder.domain.ladder;

import ladder.domain.participant.Participant;
import ladder.exception.ResultMapNullPointerException;

import java.util.Map;
import java.util.Objects;

public final class LadderResultBoard {

    private final Map<Participant, String> resultBoard;

    private LadderResultBoard(final Map<Participant, String> resultBoard) {
        this.resultBoard = resultBoard;
    }

    public static final LadderResultBoard of(final Map<Participant, String> resultBoard) {
        validateNull(resultBoard);
        return new LadderResultBoard(resultBoard);
    }

    private static final void validateNull(final Map<Participant, String> resultBoard) {
        if (Objects.isNull(resultBoard)) {
            throw new ResultMapNullPointerException();
        }
    }

    public final String findResultByParticipant(final Participant participant) {
        return resultBoard.get(participant);
    }
}
