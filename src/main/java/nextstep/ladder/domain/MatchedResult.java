package nextstep.ladder.domain;

import java.util.Map;
import java.util.Objects;

public class MatchedResult {
    private static final String CHECK_TARGET_PLAYER = "입력하신 플레이어가 존재하지 않습니다.";
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
            throw new IllegalArgumentException(CHECK_TARGET_PLAYER);
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
