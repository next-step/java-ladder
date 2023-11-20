package nextstep.ladder.domain;

import java.util.Objects;

public class PlayerResult {

    private final Name name;
    private final String result;

    public PlayerResult(Name name,
                        String result) {
        this.name = name;
        this.result = result;
    }

    public String result() {
        return this.result;
    }

    public Name name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerResult that = (PlayerResult) o;
        return Objects.equals(name, that.name) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, result);
    }
}
