package nextstep.ladder.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prizes {
    private List<Prize> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = prizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public Stream<Prize> stream() {
        return prizes.stream();
    }
}
