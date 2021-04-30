package ladder.domain;

import java.util.Objects;

public class LadderResult {
    private final Person person;
    private final Prize prize;

    public LadderResult(Person person, Prize prize) {
        this.person = person;
        this.prize = prize;
    }

    public Person name() {
        return person;
    }

    public Prize prize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(person, that.person) && Objects.equals(prize, that.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, prize);
    }
}
