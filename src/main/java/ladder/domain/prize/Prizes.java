package ladder.domain.prize;

import util.CollectionUtil;

import java.util.List;
import java.util.stream.Collectors;

import static util.Preconditions.checkArgument;

public class Prizes {
    private static final int MINIMUM_PRIZE_COUNT = 2;
    public static final String NUMBER_OF_PRIZE_MUST_BE_MORE_THEN_TWO = "number of prize must be more then two";
    private final List<Prize> prizes;

    private Prizes(final List<Prize> prizes) {
        this.prizes = prizes;
    }

    public static Prizes of(final List<Prize> prizeList) {
        checkArgument(CollectionUtil.isNotEmpty(prizeList), NUMBER_OF_PRIZE_MUST_BE_MORE_THEN_TWO);
        checkArgument(prizeList.size() >= MINIMUM_PRIZE_COUNT, NUMBER_OF_PRIZE_MUST_BE_MORE_THEN_TWO);
        return new Prizes(prizeList);
    }

    public int size() {
        return prizes.size();
    }

    public List<String> getNames() {
        return prizes.stream()
                .map(Prize::getName)
                .collect(Collectors.toList());
    }

    public Prize findPrizeByPosition(final int position) {
        return prizes.get(position);
    }
}
