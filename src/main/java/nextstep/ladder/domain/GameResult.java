package nextstep.ladder.domain;

import java.util.Collections;
import java.util.Map;

public class GameResult {

    private final Map<String, String> results;

    public GameResult(Map<String, String> results) {
        this.results = results;
    }

    public String getResultByParticipantName(String name) {
        validateParticipant(name);
        return results.get(name);
    }

    private void validateParticipant(String name) {
        if (!results.containsKey(name)) {
            throw new IllegalArgumentException("존재하지 않는 참여자입니다: " + name);
        }
    }

    public Map<String, String> getAllResults() {
        return Collections.unmodifiableMap(results);
    }
}
