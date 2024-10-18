package nextstep.ladder.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLevel> ladderLevels;

    public Ladder(List<LadderLevel> ladderLevels) {
        this.ladderLevels = ladderLevels;
    }

    public static Ladder of(int height, int groupCount) {
        return new Ladder(IntStream.range(0, height)
                .mapToObj(i -> LadderLevel.of(groupCount))
                .collect(Collectors.toList()));
    }

    public int count() {
        return ladderLevels.size();
    }

    public Collection<Collection<Boolean>> lines() {
        return ladderLevels.stream()
                .map(LadderLevel::ladderLevel)
                .collect(Collectors.toUnmodifiableList());
    }
}
