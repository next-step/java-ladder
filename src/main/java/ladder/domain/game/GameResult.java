package ladder.domain.game;

import ladder.constants.Constants;
import ladder.domain.participant.ParticipantList;
import ladder.domain.result.ResultList;

import java.util.HashMap;
import java.util.Map;

public class GameResult {

    private static final String ALL = "@all";
    public static final String DOES_NOT_EXIST_STATEMENT = "Participant does not exist. Try again";

    HashMap<String, String> result;

    public GameResult(ParticipantList participants, ResultList mappedResult) {
        this.result = new HashMap<>();
        for (int index = Constants.ZERO; index < participants.size(); index++) {
            result.put(participants.getName(index), mappedResult.getResult(index));
        }
    }

    public Map<String, String> result() {
        return this.result;
    }

    public String result(String query) {
        if (!this.result.containsKey(query)) {
            return DOES_NOT_EXIST_STATEMENT;
        }
        return this.result.get(query);
    }

    public static boolean shouldStop(String queryName) {
        return queryName.equals(ALL);
    }
}
