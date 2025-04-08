package ladder.domain;

import java.util.Objects;

public class Prize {
    private final String prize;

    public Prize(String prize) {
        this.prize = prize;
    }

    public String getPrize() {
        return prize;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Prize prize1 = (Prize) object;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
