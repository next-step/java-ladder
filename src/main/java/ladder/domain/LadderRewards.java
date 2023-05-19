package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderRewards {
    private static final String DELIMITER = ",";

    private static final String EXCEPTION_MESSAGE_REWARD_COUNT = "유저와 경품 수가 같아야 합니다.";
    private final List<Reward> ladderRewards;

    private LadderRewards(List<Reward> ladderRewards) {
        this.ladderRewards = ladderRewards;
    }

    public static LadderRewards createRewards(String inputLadderResults, int countOfUsers) {
        String[] rewards = inputLadderResults.split(DELIMITER);

        validateLadderRewards(rewards.length, countOfUsers);

        return new LadderRewards(
                Arrays.stream(rewards)
                        .map(Reward::new)
                        .collect(Collectors.toList()));
    }

    public List<Reward> ladderRewards() {
        return Collections.unmodifiableList(ladderRewards);
    }

    private static void validateLadderRewards(int countOfRewards, int countOfUsers) {
        if (countOfRewards != countOfUsers) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_REWARD_COUNT);
        }
    }

    public Reward rewardByIndex(int index) {
        return ladderRewards.get(index);
    }

}
