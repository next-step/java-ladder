package nextstep.ladder.domain;

import java.util.Objects;

public class LadderResult {
    private final String reward;

    public LadderResult(String reward) {
        this.reward = reward;
    }

    public String getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResult ladderResult = (LadderResult) o;
        return Objects.equals(reward, ladderResult.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reward);
    }
}
