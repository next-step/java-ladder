package ladder.domain;

import java.util.Objects;

public class LadderResult {
    private final Name name;
    private final Prize prize;

    public LadderResult(Name name, Prize prize) {
        this.name = name;
        this.prize = prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(name, that.name) && Objects.equals(prize, that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prize);
    }
}
