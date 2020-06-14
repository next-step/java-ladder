package ladder.domain.reward;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRewards {
    private final List<LadderReward> ladderRewards;

    private LadderRewards(String[] rewards) {
        validateReward(rewards);
        List<LadderReward> rewords = createRewords(rewards);
        this.ladderRewards = Collections.unmodifiableList(rewords);
    }

    public static LadderRewards inputRewards(String[] rewards) {
        return new LadderRewards(rewards);
    }

    public List<LadderReward> getLadderRewards() {
        return ladderRewards;
    }

    private void validateReward(String[] rewards) {
        if (rewards == null || rewards.length < 1) {
            throw new IllegalArgumentException("실행 결과를 입력하세요");
        }
    }

    private List<LadderReward> createRewords(String[] rewards) {
        return Arrays.stream(rewards)
                .map(LadderReward::inputReward)
                .collect(Collectors.toList());
    }
}
