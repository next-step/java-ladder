package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes createPrizes(List<Integer> moneys) {
        List<Prize> prizes = moneys.stream()
                .map(Prize::new)
                .collect(Collectors.toList());

        return new Prizes(prizes);
    }

    public int size() {
        return prizes.size();
    }

    public Prize get(int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return new ArrayList<>(prizes);
    }

}
