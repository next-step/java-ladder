package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LadderResult {

    private final Map<Name, String> value;

    public LadderResult(Map<Name, String> value) {
        this.value = value;
    }

    public Map<Name, String > value() {
        return new HashMap<>(value);
    }

    public String result(Name playerName) {
        if (!value.containsKey(playerName)) {
            throw new IllegalArgumentException("해당 유저가 존재하지 않습니다.");
        }

        return value.get(playerName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
