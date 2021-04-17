package nextstep.ladder.domain;

import java.util.Objects;

public class Prize {
    private final String prize;

    public Prize(String prize) {
        this.prize = prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prize prize1 = (Prize) o;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }

    @Override
    public String toString() {
        return prize;
    }
}
