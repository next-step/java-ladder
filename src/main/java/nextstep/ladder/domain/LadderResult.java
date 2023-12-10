package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {

    private final Map<String, String> value;

    public LadderResult(Map<String, String> value) {
        this.value = value;
    }

    public Map<String, String> value() {
        return new HashMap<>(value);
    }

    public String result(String playerName) {
        if (!value.containsKey(playerName)) {
            throw new IllegalArgumentException("해당 유저가 존재하지 않습니다.");
        }

        return value.get(playerName);
    }
}
