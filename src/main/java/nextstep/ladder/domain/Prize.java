package nextstep.ladder.domain;

import java.util.Objects;

public class Prize {

    private final String prize;

    public Prize(String prize) {
        validatePrize(prize);
        this.prize = prize;
    }

    private void validatePrize(String prize) {
        if (prize == null || prize.isBlank()) {
            throw new IllegalArgumentException("invalid prize. prize: " + prize);
        }
    }

    public String getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize1 = (Prize) o;
        return Objects.equals(getPrize(), prize1.getPrize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrize());
    }
}
