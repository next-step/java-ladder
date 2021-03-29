package ladder.domain.game;

import ladder.domain.participant.ParticipantList;
import ladder.domain.result.ResultList;

import java.util.HashMap;

public class GameResult {

    private static final String ALL = "@all";

    HashMap<String, String> result;

    public GameResult(ParticipantList participants, ResultList mappedResult) {
        this.result = new HashMap<>();
        for (int index = 0; index < participants.size(); index++) {
            result.put(participants.getName(index), mappedResult.getResult(index));
        }
    }

    public String result(String query) {
        return "";
    }
}
