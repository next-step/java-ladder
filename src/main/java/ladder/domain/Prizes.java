package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Prizes {
    private static final int RULE_PRIZE_MIN_COUNT = 2;
    private List<Prize> prizes;

    public Prizes(List<String> inputs) {
        int prizeCount = inputs.size();
        validate(prizeCount);
        this.prizes = inputsToPrizes(inputs);
    }

    public List<Prize> getPrizes() {
        return new ArrayList<>(this.prizes);
    }

    public int count() {
        return this.prizes.size();
    }

    public Prize getPrize(int index) {
        return this.prizes.get(index);
    }

    private List<Prize> inputsToPrizes(List<String> inputs) {
        List<Prize> prizes = new ArrayList<>();
        for (String input : inputs) {
            prizes.add(Prize.of(input));
        }
        return prizes;
    }

    private void validate(int prizeCount) {
        if (prizeCount < RULE_PRIZE_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("플레이어는 %d명 이상이어야 합니다.", RULE_PRIZE_MIN_COUNT));
        }
    }
}
