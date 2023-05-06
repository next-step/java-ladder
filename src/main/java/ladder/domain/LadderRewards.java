package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static ladder.utils.LadderUtil.DELIMITER;

public class LadderRewards {

  private static final String ILLEGAL_COUNT_MESSAGE = "유저와 경품 수가 같아야 합니다.";
  private final List<LadderReward> ladderRewards;

  private LadderRewards(List<LadderReward> ladderRewards) {
    this.ladderRewards = ladderRewards;
  }

  public static LadderRewards createRewards(String inputLadderResults, int countOfUsers) {
    String[] rewards = inputLadderResults.split(DELIMITER);

    validateLadderRewards(rewards.length, countOfUsers);

    return new LadderRewards(
            Arrays.stream(rewards)
                    .map(LadderReward::new)
                    .collect(Collectors.toList()));
  }

  public List<LadderReward> ladderRewards() {
    return Collections.unmodifiableList(ladderRewards);
  }

  private static void validateLadderRewards(int countOfRewards, int countOfUsers) {
    if (countOfRewards != countOfUsers) {
      throw new IllegalArgumentException(ILLEGAL_COUNT_MESSAGE);
    }
  }
}
