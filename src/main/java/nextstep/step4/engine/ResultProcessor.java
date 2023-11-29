package nextstep.step4.engine;

import java.util.List;

public class ResultProcessor {
    List<Participant> participants;
    List<Result> results;

    public ResultProcessor(final List<Participant> participants, final List<Result> results) {
        this.participants = participants;
        this.results = results;
    }

    String toResult(LadderResult ladderResult) {
        return null;
    }
}
