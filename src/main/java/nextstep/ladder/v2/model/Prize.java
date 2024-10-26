package nextstep.ladder.v2.model;

import java.util.Objects;

public class Prize {
    private String worth;

    public Prize(String worth) {
        if (!worth.equals("꽝")) {
            checkPrizeRange(worth);
        }
        this.worth = worth;
    }

    public String getWorth() {
        return worth;
    }

    private static void checkPrizeRange(String worth) {
        int price = Integer.parseInt(worth);
        if (price <= 0) {
            throw new IllegalArgumentException("price must be greater than 0");
        }
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
        return Objects.equals(worth, prize.worth);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(worth);
    }
}
