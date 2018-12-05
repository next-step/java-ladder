package net.chandol.ladder.v2.domain.prize;

import net.chandol.ladder.v2.support.StringUtils;

import java.util.Objects;

import static net.chandol.ladder.v2.support.Constants.PRIZE_MAX_LENGTH;

public class Prize {
    private String value;

    public Prize(String value) {
        StringUtils.validateString(value, PRIZE_MAX_LENGTH);
        this.value = value;
    }

    public String getPrizeWithFixedLength() {
        return StringUtils.toFixedLength(value, PRIZE_MAX_LENGTH);
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
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return value;
    }

    public static Prize prize(String value) {
        return new Prize(value);
    }

    public String getValue() {
        return this.value;
    }
}
