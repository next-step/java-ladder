package nextstep.ladder.domain.engine;

import java.util.Map;
import java.util.Objects;

public class PlayResult {

    private final Map<Integer, Integer> result;

    public PlayResult(Map<Integer, Integer> result) {
        this.result = result;
    }

    public int get(int key) {
        return result.get(key);
    }

    public int size() {
        return result.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayResult)) return false;
        PlayResult that = (PlayResult) o;
        return result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
