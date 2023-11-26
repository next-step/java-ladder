package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    public Prizes(List<String> prizes) {
        this.prizes = prizes.stream()
                .map(Prize::new)
                .collect(Collectors.toList());
    }

    public List<Prize> prizes() {
        return Collections.unmodifiableList(prizes);
    }

}
