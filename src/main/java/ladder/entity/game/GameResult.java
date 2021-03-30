package ladder.entity.game;

import ladder.entity.participant.Participant;
import ladder.entity.participant.ParticipantList;
import ladder.entity.resultCase.ResultCase;
import ladder.entity.resultCase.ResultCaseList;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private static final String ALL = "@all";
    public static final String DOES_NOT_EXIST_STATEMENT = "Participant does not exist. Try again";

    HashMap<Participant, ResultCase> result;

    public GameResult(ParticipantList participants, ResultCaseList mappedResult) {
        this.result = new HashMap<>();
        for (int index = 0; index < participants.size(); index++) {
            result.put(participants.get(index), mappedResult.get(index));
        }
    }

    public Map<Participant, ResultCase> result() {
        return this.result;
    }

    public ResultCase result(String query) {
        Participant participant = new Participant(query);
        if (!this.result.containsKey(participant)) {
            return new ResultCase(DOES_NOT_EXIST_STATEMENT);
        }
        return this.result.get(participant);
    }

    public static boolean shouldStop(String queryName) {
        return queryName.equals(ALL);
    }
}
