package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class MachingResult {
    private final Map<Integer, Integer> machingResultMap;

    public MachingResult(Map<Integer, Integer> machingResultMap) {
        this.machingResultMap = new HashMap<>(machingResultMap);
    }

    public void addResult(int initialX, int x) {
        machingResultMap.put(initialX, x);
    }

    public Map<Integer, Integer> getMachingResultMap() {
        return machingResultMap;
    }

    public LadderResult map(Participants participants, ExecuteResult executeResult) {
        LadderResult ladderResult = new LadderResult();

        for (Participant participant : participants.getParticipants()) {
            ladderResult.addResult(participant, executeResult.getResultsWithPosition(machingResultMap.get(participant.getPositionX())));
        }

        return ladderResult;
    }
}
