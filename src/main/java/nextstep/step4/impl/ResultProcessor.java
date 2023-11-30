package nextstep.step4.impl;

import nextstep.step4.engine.LadderResult;

public class ResultProcessor {
    public static final String NEW_LINE = "\n";
    private Participants participants;
    private Results results;

    public ResultProcessor(final Participants participants, final Results results) {
        this.participants = participants;
        this.results = results;
    }

    public String toResult(LadderResult ladderResult) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer source : ladderResult.keys()) {
            final Participant participant = participants.get(source);
            final String result = results.get(ladderResult.get(source));
            stringBuilder.append(String.format("%s : %s", participant.toString(), result) + NEW_LINE);
        }

        return stringBuilder.toString();
    }
}
