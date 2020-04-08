package ladder.domain;

import java.util.Objects;

public class Prize {
    private final Position prizePosition;
    private final String prize;

    public Prize(final int position, final String prize) {
        this.prizePosition = new Position(position);
        this.prize = prize;
    }

    public boolean match(final Position position) {
        return prizePosition.equals(position);
    }

    public String getPrize() {
        return prize;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Prize prize1 = (Prize) o;
        return Objects.equals(prizePosition, prize1.prizePosition) &&
                Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizePosition, prize);
    }

}
