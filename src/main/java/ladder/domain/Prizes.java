package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> prizeList;

    private Prizes(List<Prize> prizeList) {
        this.prizeList = prizeList;
    }

    public static Prizes of(List<String> prizeList) {
        return new Prizes(prizeList.stream()
                .map(Prize::new)
                .collect(Collectors.toList()));
    }

    public Prize getPrizeByPosition(int position) {
        return prizeList.get(position);
    }

}
