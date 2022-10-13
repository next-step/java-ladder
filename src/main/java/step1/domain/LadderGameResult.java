package step1.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {

    private final Map<UserName, Prize> ladderGameResult = new HashMap<>();

    public LadderGameResult(Map<UserName, Prize> ladderGameResult) {
        this.ladderGameResult.putAll(ladderGameResult);
    }

    public Map<UserName, Prize> getLadderGameResult() {
        return ladderGameResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderGameResult)) {
            return false;
        }

        LadderGameResult that = (LadderGameResult) o;

        return ladderGameResult.equals(that.ladderGameResult);
    }

    @Override
    public int hashCode() {
        return ladderGameResult.hashCode();
    }
}
