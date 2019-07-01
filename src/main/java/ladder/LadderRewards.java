package ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderRewards {
    private final List<LadderRewardType> ladderRewardTypes;

    private LadderRewards(List<LadderRewardType> ladderRewardTypes) {
        this.ladderRewardTypes = ladderRewardTypes;
    }

    public static LadderRewards of(int countOfPerson) {
        List<LadderRewardType> ladderRewardTypes = IntStream.range(0, countOfPerson)
                                                            .mapToObj(index -> LadderRewardType.getRandomType())
                                                            .collect(Collectors.toList());

        return new LadderRewards(ladderRewardTypes);
    }

    public List<LadderRewardType> getLadderRewardTypes() {
        return Collections.unmodifiableList(this.ladderRewardTypes);
    }
}
