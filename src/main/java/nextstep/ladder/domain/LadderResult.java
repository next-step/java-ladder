package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {

    private final ExecuteResult executeResult;
    private final LadderExecutor ladderExecutor;
    private final Participants participants;

    public LadderResult(ExecuteResult executeResult, LadderExecutor ladderExecutor) {
        this.executeResult = executeResult;
        this.ladderExecutor = ladderExecutor;
        this.participants = combineLadderResult();
    }

    public Participants combineLadderResult() {
        List<Participant> newParticipants = new ArrayList<>();
        for (Participant participant : ladderExecutor.getParticipants()) {
            Position position = ladderExecutor.getParticipantFinalPosition(participant);
            String result = executeResult.getResultsWithPosition(position);
            participant = new Participant(participant.getName(), position, result);
            newParticipants.add(participant);
        }
        return new Participants(newParticipants);
    }

    public Participants getPartitions() {
        return participants;
    }

    public List<Participant> getPartitionList() {
        return participants.getParticipants();
    }

    public ExecuteResult getExecuteResult() {
        return executeResult;
    }

    public String getParticipantResult(String participant) {
       return participants.getParticipantResult(participant);
    }
}


