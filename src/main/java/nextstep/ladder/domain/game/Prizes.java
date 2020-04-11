package nextstep.ladder.domain.game;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<String> getNames() {
        return prizes.stream()
                .map(Prize::getName)
                .collect(Collectors.toList());
    }
}
