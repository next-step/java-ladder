package ladder.prize.domain;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Prizes {
    private final List<Prize> prizes;

    private Prizes(List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(List<String> prizes) {
        return prizes.stream()
                .map(Prize::of)
                .collect(collectingAndThen(toList(), Prizes::new));
    }

    public int size() {
        return prizes.size();
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getPrize)
                .collect(toList());
    }

    public Prize getPrize(int resultIndex) {
        return prizes.get(resultIndex);
    }
}
