package ladder.domain;

import ladder.LadderReward;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRewards {
    private final List<LadderReward> ladderRewards;

    private LadderRewards(List<LadderReward> ladderRewards) {
        this.ladderRewards = ladderRewards;
    }

    public static LadderRewards of(String resultsString) {
        String[] textOfResults = resultsString.split(",");
        List<LadderReward> ladderRewards = Arrays.stream(textOfResults)
                                                 .map(LadderReward::of)
                                                 .collect(Collectors.toList());

        return new LadderRewards(ladderRewards);
    }

    public int size() {
        return this.ladderRewards.size();
    }

    public LadderReward getLadderReward(int index) {
        int lastIndex = ladderRewards.size() - 1;

        if (index < 0 || index > lastIndex) {
            throw new IndexOutOfBoundsException("the index must between 0 and " + lastIndex);
        }

        return this.ladderRewards.get(index);
    }
}
