package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameResult {
    private final Map<String, String> playerAndResult;

    public LadderGameResult(Ladders ladders, Participants participants, Results results) {
        this.playerAndResult = recordResult(ladders, participants, results);
    }

    private Map<String, String> recordResult(Ladders ladders, Participants participants, Results results) {
        List<String> players = participants.getParticipants();
        return players.stream()
                .collect(Collectors.toMap(
                        player -> player,
                        player -> results.getFinalResult(ladders.traverseLadderDown(players.indexOf(player))),
                        (player, result) -> player,
                        LinkedHashMap::new
                ));
    }

    public Map<String, String> getAllResultOfPlayer() {
        return new LinkedHashMap<>(playerAndResult);
    }

    public String getSpecificPlayerResult(String name) {
        return playerAndResult.get(name);
    }

}
