package nextstep.ladder.domain;

import java.util.Map;

public class GameResults {
    public static final String NO_PARTICIPANT_ERROR = "해당 이름을 가진 참가자가 없습니다. [이름: %s]";
    private Map<String, String> gameResult;

    public GameResults(Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public String getResult(String name) {
        assertValidParticipant(name);
        return gameResult.get(name);
    }

    private void assertValidParticipant(String name) {
        if(gameResult.get(name) == null) {
            throw new IllegalArgumentException(String.format(NO_PARTICIPANT_ERROR, name));
        }
    }

    public Map<String, String> getValue() {
        return gameResult;
    }
}
