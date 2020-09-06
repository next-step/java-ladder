package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizeNames) {
        List<Prize> prizes = prizeNames.stream()
                                        .map(Prize::new)
                                        .collect(Collectors.toList());
        return new Prizes(prizes);
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getPrize)
                .collect(Collectors.toList());
    }

}
