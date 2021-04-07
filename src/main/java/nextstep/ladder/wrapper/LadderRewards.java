package nextstep.ladder.wrapper;

import nextstep.ladder.domain.Position;
import nextstep.ladder.domain.Reward;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderRewards {

    private final List<Reward> rewards;

    private LadderRewards(final Reward... rewards) {
        this.rewards = Arrays.asList(rewards);
    }

    public static LadderRewards valueOf(final Reward... ladderRewards) {
        return new LadderRewards(ladderRewards);
    }

    public Reward findReward(final Position endPosition) {
        return rewards.get(endPosition.currentPosition());
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderRewards)) return false;
        final LadderRewards that = (LadderRewards) o;
        return Objects.equals(rewards, that.rewards);
    }
    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }

}
