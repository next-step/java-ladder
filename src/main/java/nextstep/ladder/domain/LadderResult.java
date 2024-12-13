package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {

    private final Map<Participant, String> playerToReward;

    public LadderResult() {
        playerToReward = new HashMap<>();
    }

    public LadderResult(Map<Participant, String> playerToReward) {
        this.playerToReward = new HashMap<>(playerToReward);

    }

    public void addResult(Participant participant, String result) {
        playerToReward.put(participant, result);
    }

    public Map<Participant, String> getPlayerToReward() {
        return playerToReward;
    }

    public String getReward(String name) {
        return playerToReward.get(new Participant(name));
    }
}


