package nextstep.ladder.domain.reward;

import java.util.Arrays;

public class TestRewards {

    private TestRewards() {}

    public static Rewards rewards() {
        return Rewards.of(Arrays.asList("꽝", "5000", "꽝", "3000"));
    }

}
