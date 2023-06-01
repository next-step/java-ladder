package ladder.domain;

public class LadderGame {

    private final Ladder ladder;
    private final ParticipantNames participantNames;
    private final ExecutionResults executionResults;

    public LadderGame(Ladder ladder, ParticipantNames participantNames, ExecutionResults executionResults) {
        validateLadderGameSize(participantNames, executionResults);
        this.ladder = ladder;
        this.participantNames = participantNames;
        this.executionResults = executionResults;
    }

    private void validateLadderGameSize(ParticipantNames participantNames, ExecutionResults executionResults) {
        if (participantNames.getParticipantsSize() != executionResults.getExecutionResultsSize()) {
            throw new IllegalArgumentException(sendExceptionMessageForLadderGameSize(participantNames, executionResults));
        }
    }

    private String sendExceptionMessageForLadderGameSize(ParticipantNames participantNames, ExecutionResults executionResults) {
        return String.format("참가자 수와 실행 결과 수가 일치하지 않습니다. ParticipantsSize : %d, ExecutionResultsSize : %d",
                participantNames.getParticipantsSize(), executionResults.getExecutionResultsSize());
    }

    public ExecutionResult findEachResult(ParticipantName participantName) {
        return executionResults.getEachResult(findFinalIndex(participantNames.getIndex(participantName)));
    }

    private int findFinalIndex(int index) {
        return ladder.getLines()
                .stream()
                .reduce(index, (finalIndex, line) -> line.findNextIndex(finalIndex), (a, b) -> b);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public ParticipantNames getParticipantNamesAsEntity() {
        return participantNames;
    }

    public ExecutionResults getExecutionResults() {
        return executionResults;
    }
}
