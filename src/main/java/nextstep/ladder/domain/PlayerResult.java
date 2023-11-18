package nextstep.ladder.domain;

import java.util.Objects;

public class PlayerResult {

    private final Name name;
    private final int endPoint;

    public PlayerResult(Name name,
                        int endPoint) {
        this.name = name;
        this.endPoint = endPoint;
    }

    public int endPoint() {
        return this.endPoint;
    }

    public Name name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerResult that = (PlayerResult) o;
        return endPoint == that.endPoint && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, endPoint);
    }

}
