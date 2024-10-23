package nextstep.ladder.model;

import java.util.Objects;

public class Prize {
    private String worth;

    public Prize(String worth) {
        if (worth.isBlank()) {
            throw new IllegalArgumentException("Prize value cannot be blank");
        }
        this.worth = worth;
    }

    public String getWorth() {
        return worth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prize)) {
            return false;
        }
        Prize prize = (Prize) o;
        return Objects.equals(getWorth(), prize.getWorth());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getWorth());
    }
}
