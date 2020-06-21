package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Prices {
    private final List<Price> prices;

    public Prices(List<Price> prices) {
        this.prices = prices;
    }

    public Stream<Price> stream() {
        return prices.stream();
    }

    public String getMoney(int x) {
        return prices.get(x).getMoney();
    }
}
