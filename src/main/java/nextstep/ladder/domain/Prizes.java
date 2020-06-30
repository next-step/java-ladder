package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public Stream<Prize> stream() {
        return prizes.stream();
    }

    public Prize getPrice(int index) {
        return prizes.get(index);
    }
}
