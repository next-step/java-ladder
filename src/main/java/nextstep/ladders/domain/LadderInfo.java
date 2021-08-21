package nextstep.ladders.domain;

import nextstep.ladders.domain.exceptions.DifferentCountException;

import java.util.Arrays;

public class LadderInfo {

    private Participants participants;
    private ExecutionResults executionResults;

    public LadderInfo(final String participantsText, final String executionResultText) {
        checkEqualsCount(participantsText, executionResultText);
        this.participants = new Participants(participantsText);
        this.executionResults = new ExecutionResults(executionResultText);
    }

    private void checkEqualsCount(final String participantsText, final String executionResultText) {
        long participantsCount = Arrays.stream(participantsText.split(",")).count();
        long executionResultCount = Arrays.stream(executionResultText.split(",")).count();
        if (participantsCount != executionResultCount) {
            throw new DifferentCountException();
        }
    }

    public Participants getParticipants() {
        return participants;
    }

    public ExecutionResults getExecutionResults() {
        return executionResults;
    }
}
