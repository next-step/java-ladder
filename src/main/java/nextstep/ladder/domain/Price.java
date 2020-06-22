package nextstep.ladder.domain;

import java.util.regex.Pattern;

public class Price {
    private static final Pattern PRICE_REGEX = Pattern.compile("^(꽝|[0-9]+)$");
    private final String money;

    public Price(String money) {
        if (PRICE_REGEX.matcher(money).matches()) {
            this.money = money;
            return;
        }
        throw new IllegalArgumentException("`money` is must 꽝 or number");
    }

    public String getMoney() {
        return money;
    }
}
