package ladder.domain.ladder.reward;


import exception.ExceptionCode;
import exception.LadderGameException;
import java.util.Objects;

public class LadderGameReward {
  private final int rewardPrize;

  public LadderGameReward(int rewardPrize) {
    throwIfRewardPrizeIsNotPositive(rewardPrize);
    this.rewardPrize = rewardPrize;
  }

  private void throwIfRewardPrizeIsNotPositive(int rewardPrize) {
    if (rewardPrize < 0) {
      throw new LadderGameException(ExceptionCode.REWARD_MUST_POSITIVE_ZERO);
    }
  }

  public int getRewardPrize() {
    return rewardPrize;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LadderGameReward that = (LadderGameReward) o;
    return rewardPrize == that.rewardPrize;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rewardPrize);
  }

  @Override
  public String toString() {
    return "LadderGameReward{rewardPrize=" + rewardPrize + '}';
  }
}
