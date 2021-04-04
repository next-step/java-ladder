package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderRewards {

    private final List<String> ladderRewards;

    public LadderRewards(String... ladderRewards) {
        this.ladderRewards = Arrays.asList(ladderRewards);
    }

    public static LadderRewards valueOf(String... ladderRewards) {
        return new LadderRewards(ladderRewards);
    }

    public List<String> getLadderRewards() {
        return Collections.unmodifiableList(ladderRewards);
    }

    @Override
    public boolean equals(Object o) {
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
