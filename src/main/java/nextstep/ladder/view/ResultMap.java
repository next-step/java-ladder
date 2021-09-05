package nextstep.ladder.view;

import nextstep.ladder.Position;
import nextstep.ladder.participant.Participant;
import nextstep.ladder.participant.Participants;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResultMap {
    Map<String, Position> participantMap;
    Position non = new Position(999,999);
    public ResultMap(Participants participants){
        this.participantMap = new HashMap<>();
        participants.getList().stream()
                .forEach(vo -> participantMap.put(vo.getName(), vo.getPosition()));
    }
    public Position findPosition(String name){
        return Optional.ofNullable(participantMap.get(name)).orElse(non);
    }
}
