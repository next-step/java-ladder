package laddergame.domain.game;

import java.util.Map;
import java.util.Set;

public class GameResult {
    private final Map<String, Result> resultMap;

    public GameResult(final Map<String, Result> resultMap) {
        this.resultMap = resultMap;
    }

    public Result findByName(final String name) {
        validateFindName(name);
        return resultMap.get(name);
    }

    public Set<Map.Entry<String, Result>> findAll() {
        return resultMap.entrySet();
    }

    private void validateFindName(final String name) {
        if (!resultMap.containsKey(name)) {
            throw new IllegalArgumentException("존재하지않는 이름입니다. - " + name);
        }
    }
}
