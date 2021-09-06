package nextstep.ladder.view;

import nextstep.ladder.Position;
import nextstep.ladder.Result;
import nextstep.ladder.participant.Participants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ResultMap {
    private Map<String, Position> participantMap;
    private Map<Integer, String> resultMap;
    private Map<String, String> allResult = new HashMap<>();
    private Position non = new Position(999, 999);

    public ResultMap(Participants participants, List<Result> results) {
        this.participantMap = new HashMap<>();
        participants.players().stream()
                .forEach(vo -> participantMap.put(vo.getName(), vo.position()));
        this.resultMap = new HashMap<>();
        results.stream()
                .forEach(vo -> resultMap.put(vo.position(), vo.value()));
        participantMap.keySet().stream()
                .forEach(name -> allResult.put(name, resultMap.get(participantMap.get(name).value())));
    }

    public Position findPosition(String name) {
        return Optional.ofNullable(participantMap.get(name)).orElse(non);
    }

    public String findResult(String name) {
        int index = participantMap.get(name).value();
        return Optional.ofNullable(resultMap.get(index)).orElse("Not Exist");
    }

    public Map<String, String> allResult() {
        return this.allResult;
    }
}
