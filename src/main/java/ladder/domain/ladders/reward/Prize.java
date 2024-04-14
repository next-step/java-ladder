package ladder.domain.ladders.reward;

import java.util.Objects;

public class Prize {

    private final String item;

    public Prize(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prize)) return false;
        Prize prize = (Prize) o;
        return Objects.equals(this.item, prize.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
