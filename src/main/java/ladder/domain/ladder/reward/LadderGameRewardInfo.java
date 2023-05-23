package ladder.domain.ladder.reward;

import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import utils.StringUtils;

public class LadderGameRewardInfo {
  private static final String ZERO_VALUE_ALIAS = "꽝";
  private static final Map<Integer, LadderGameReward> rewardCache = new HashMap<>();

  private final List<LadderGameReward> rewards;

  public LadderGameRewardInfo(List<String> rawRewards) {
    this.rewards = rawRewards.stream()
        .map(this::createReward)
        .collect(Collectors.toUnmodifiableList());
  }

  public LadderGameReward getRewardAt(int lineIndex) {
    return rewards.get(lineIndex);
  }

  private LadderGameReward createReward(String rawReward) {
    int prize = getRewardPrizeFromRawReward(rawReward);
    LadderGameReward ladderGameReward = rewardCache.get(prize);
    if (ladderGameReward != null) {
      return ladderGameReward;
    }

    LadderGameReward newReward = new LadderGameReward(prize);
    rewardCache.putIfAbsent(prize, newReward);

    return newReward;
  }

  private int getRewardPrizeFromRawReward(String rawReward) {
    if(ZERO_VALUE_ALIAS.equals(rawReward)) {
      return 0;
    }

    if (StringUtils.isDigit(rawReward)) {
      return Integer.parseInt(rawReward);
    }

    throw new LadderGameException(ExceptionCode.REWARD_IS_NOT_NUMERIC);
  }
}
