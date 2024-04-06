package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderMapping {
    private final Map<Participant, Destination> mappings;

    public LadderMapping(Participants participants, ExecutionResults executionResults){
        this(generateMap(participants, executionResults));
    }

    public LadderMapping(Map<Participant, Destination> mappings) {
        this.mappings = mappings;
    }

    private static Map<Participant, Destination> generateMap(Participants participants, ExecutionResults executionResults){
        HashMap<Participant, Destination> hm = new HashMap<>();
        for(int i =0; i < participants.getSize(); i++){
            hm.put(participants.getByOrder(i), executionResults.getByOrder(i));
        }
        return  hm;
    }

    public Destination showResult(Participant participant){
        if(participant == null){
            throw new IllegalArgumentException();
        }
        Destination destination = mappings.get(participant);
        if(destination == null){
            throw new IllegalArgumentException();
        }
        return destination;
    }
}
