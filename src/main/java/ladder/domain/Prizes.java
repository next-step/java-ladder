package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizeList) {
        return new Prizes(prizeList.stream()
                .map(Prize::new)
                .collect(Collectors.toList()));
    }

    public Prize getPrizeByPosition(int position) {
        return prizes.get(position);
    }

    public List<Prize> getPrizes() {
        return prizes;
    }
}
