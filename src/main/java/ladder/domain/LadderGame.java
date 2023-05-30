package ladder.domain;

public class LadderGame {

    private final Ladder ladder;
    private final ParticipantNames participantNames;
    private final ExecutionResults executionResults;

    public LadderGame(Ladder ladder, ParticipantNames participantNames, ExecutionResults executionResults) {
        this.ladder = ladder;
        this.participantNames = participantNames;
        this.executionResults = executionResults;
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
