package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderMapping {
    private final Map<Participant, ExecutionResult> mappings;

    public LadderMapping(Participants participants, ExecutionResults executionResults){
        this(generateMap(participants, executionResults));
    }

    public LadderMapping(Map<Participant, ExecutionResult> mappings) {
        this.mappings = mappings;
    }

    private static Map<Participant, ExecutionResult> generateMap(Participants participants, ExecutionResults executionResults){
        HashMap<Participant, ExecutionResult> hm = new HashMap<>();
        for(int i =0; i < participants.getSize(); i++){
            hm.put(participants.getByOrder(i), executionResults.getByOrder(i));
        }
        return  hm;
    }

    public ExecutionResult showResult(Participant participant){
        if(participant == null){
            throw new IllegalArgumentException();
        }
        ExecutionResult executionResult = mappings.get(participant);
        if(executionResult == null){
            throw new IllegalArgumentException();
        }
        return executionResult;
    }
}
