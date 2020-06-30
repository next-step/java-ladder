package nextstep.ladder.domain.prizes;

import java.util.regex.Pattern;

public class Prize {
    private static final Pattern PRICE_REGEX = Pattern.compile("^(꽝|[0-9]+)$");
    private final String prize;

    public Prize(String prize) {
        validatePrize(prize);
        this.prize = prize;
    }

    private void validatePrize(String prize) {
        if (!PRICE_REGEX.matcher(prize).matches()) {
            throw new IllegalArgumentException("prize must be 꽝 or number");
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

        return this.prize.equals(prize1.getPrize());
    }

    @Override
    public int hashCode() {
        return prize != null ? prize.hashCode() : 0;
    }
}
