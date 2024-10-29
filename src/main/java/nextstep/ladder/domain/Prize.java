package nextstep.ladder.domain;

import java.util.Objects;

public class Prize {
    private final String value;

    public Prize(String ladderResult) {
        this.value = ladderResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize = (Prize) o;
        return Objects.equals(value, prize.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
