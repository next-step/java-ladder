package step2.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static step2.view.ViewConstants.COMMA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prizes {

    private final List<Prize> prizes = new ArrayList<>();

    public Prizes(String products) {
        createPrizes(products);
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public int size() {
        return prizes.size();
    }

    public List<Prize> value() {
        return this.prizes;
    }

    private void createPrizes(String products) {
        Arrays.stream(products.split(COMMA))
            .map(Prize::new)
            .collect(collectingAndThen(toList(), prizes::addAll));
    }
}
