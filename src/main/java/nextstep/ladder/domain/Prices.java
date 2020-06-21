package nextstep.ladder.domain;

import java.util.List;

public class Prices {
    private final List<Price> prices;

    public Prices(List<Price> prices) {
        this.prices = prices;
    }

    public String getMoney(int x) {
        return prices.get(x).getMoney();
    }
}
