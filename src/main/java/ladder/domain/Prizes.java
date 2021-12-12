package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    public static final String PRODUCTS_COUNT_ERROR_MESSAGE = "error : 상품은 참가자 수와 동일해야 합니다.";

    private final List<Prize> prizes;

    private Prizes(List<Prize> products, Names names) {
        validPrizeCount(products, names);
        this.prizes = Collections.unmodifiableList(products);
    }

    public static Prizes of(List<String> prizes, Names names) {
        return new Prizes(prizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList()), names);
    }

    private void validPrizeCount(List<Prize> prizes, Names names) {
        if (prizes.size() != names.size()) {
            throw new IllegalArgumentException(PRODUCTS_COUNT_ERROR_MESSAGE);
        }
    }

    public int size() {
        return prizes.size();
    }

    public Prize prize(int index){
        return prizes.get(index);
    }

    public String value(int index) {
        return prizes.get(index).value();
    }
}
