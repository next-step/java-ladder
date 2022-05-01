package nextstep.ladder.domain;

import java.util.Objects;

public class Prize {

    private final int prize;

    public Prize(int prize) {
        validatePrize(prize);
        this.prize = prize;
    }

    private void validatePrize(int prize) {
        if (prize < 0) {
            throw new IllegalArgumentException("prize must be greater or equal than zero. prize: " + prize);
        }
    }

    public int getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize1 = (Prize) o;
        return getPrize() == prize1.getPrize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrize());
    }
}
