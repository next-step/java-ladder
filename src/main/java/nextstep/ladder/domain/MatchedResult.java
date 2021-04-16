package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;

import java.util.Map;
import java.util.Objects;

import static nextstep.ladder.exception.LadderExceptionMessage.CHECK_TARGET_PLAYER_NAME;

public class MatchedResult {
    private static final String ALL = "all";

    private final Map<String, String> matchedResult;

    public MatchedResult(Map<String, String> matchedResult) {
        this.matchedResult = matchedResult;
    }

    public boolean isAll(String target) {
        return Objects.equals(target, ALL);
    }

    public Iterable<? extends Map.Entry<String, String>> all() {
        return matchedResult.entrySet();
    }

    public boolean containsKey(String targetPlayerName) {
        if (!matchedResult.containsKey(targetPlayerName)) {
            throw new LadderException(CHECK_TARGET_PLAYER_NAME);
        }

        return matchedResult.containsKey(targetPlayerName);
    }

    public String get(String targetPlayer) {
        return matchedResult.get(targetPlayer);
    }

    public int size() {
        return matchedResult.size();
    }
}
