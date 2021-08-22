package nextstep.ladders.domain;

import nextstep.ladders.domain.exceptions.NotFoundDataException;

import java.util.Arrays;
import java.util.List;

public class Ladder {

    public static final String REGEX_COMMA = ",";

    private final LadderDetail ladderDetail;
    private final Lines lines;

    public Ladder(final LadderDetail ladderDetail, final Lines lines) {
        this.ladderDetail = ladderDetail;
        this.lines = lines;
    }

    public Ladder(final PointGenerateStrategy strategy, final String participantsText, final String executionResultText, final String maxLadderHeightText) {
        this(new LadderDetail(participantsText, executionResultText), new Lines(strategy, parseParticipantsCount(participantsText), parseMaxLadderHeight(maxLadderHeightText)));
    }

    private static int parseParticipantsCount(final String participantsText) {
        return (int) (Arrays.stream(participantsText.split(REGEX_COMMA)).count());
    }

    private static int parseMaxLadderHeight(final String maxLadderHeightText) {
        return Integer.parseInt(maxLadderHeightText);
    }

    public ExecutionResult start(final Participant participant) {
        List<Participant> participants = ladderDetail.getParticipants().getParticipants();
        List<ExecutionResult> executionResult = ladderDetail.getExecutionResults().getExecutionResult();
        int row = participants.indexOf(participant);
        if (row == -1) {
            throw new NotFoundDataException();
        }
        int result = lines.start(row);
        return executionResult.get(result);
    }

    public Lines getLines() {
        return lines;
    }

    public LadderDetail getLadderDetail() {
        return ladderDetail;
    }
}
