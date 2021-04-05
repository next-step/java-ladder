package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderRewards {

    private final List<Reward> ladderRewards;

    private LadderRewards(final Reward... ladderRewards) {
        this.ladderRewards = Arrays.asList(ladderRewards);
    }

    public static LadderRewards valueOf(final Reward... ladderRewards) {
        return new LadderRewards(ladderRewards);
    }

    public static LadderRewards valueOf(final String... ladderRewards) {
        return new LadderRewards(parseRewards(ladderRewards));
    }

    private static Reward[] parseRewards(String[] ladderRewards) {
        return Arrays.stream(ladderRewards)
                .map(Reward::valueOf)
                .toArray(Reward[]::new);
    }

    public List<Reward> getLadderRewards() {
        return Collections.unmodifiableList(ladderRewards);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderRewards)) return false;
        final LadderRewards that = (LadderRewards) o;
        return Objects.equals(ladderRewards, that.ladderRewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderRewards);
    }
}
