package ladder.domain.game;

import ladder.domain.ladder.Position;

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

    public LadderReward getLadderReward(Position position) {
        validatePosition(position);
        return ladderRewards.get(position.getValue());
    }

    public List<LadderReward> getLadderRewards() {
        return ladderRewards;
    }

    private List<LadderReward> createRewords(String[] rewards) {
        return Arrays.stream(rewards)
                .map(LadderReward::inputReward)
                .collect(Collectors.toList());
    }

    private void validateReward(String[] rewards) {
        if (rewards == null || rewards.length < 1) {
            throw new IllegalArgumentException("보상을 빈칸 혹은 null 로 입력하였습니다.");
        }
    }

    private void validatePosition(Position position) {
        if (position == null ||  position.getValue() > ladderRewards.size()) {
            throw new IllegalArgumentException("유효하지 않은 position 을 입력했습니다.");
        }
    }

    @Override
    public String toString() {
        return "LadderRewards{" +
                "ladderRewards=" + ladderRewards +
                '}';
    }
}
