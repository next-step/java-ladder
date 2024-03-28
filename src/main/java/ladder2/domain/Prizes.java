package ladder2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prizes {

    private final Map<Integer, Prize> prizes;

    public Prizes(List<Prize> prizes) {
        this(
            prizes.stream().collect(
                Collectors.toMap(Prize::index, prize -> prize)
            )
        );
    }

    public Prizes(Map<Integer, Prize> prizes) {
        this.prizes = prizes;
    }

    public Prize get(int index) {
        return prizes.get(index);
    }
}
