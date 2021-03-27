package ladder.domain.ladderMap;

import ladder.domain.Ladder;
import ladder.domain.ParticipantList;

import java.util.ArrayList;
import java.util.List;

public class LadderMap {
    private String names;
    private Plane plane;

    public LadderMap(ParticipantList participantList, Ladder ladder){
        this.names = participantList.flattenedNames();
        this.plane = new Plane(participantList, ladder);
    }

    public List<String> dto(){
        List<String> ladderMap = new ArrayList<>();
        ladderMap.add(names);
        ladderMap.addAll(plane.dto());
        return ladderMap;
    }
}
