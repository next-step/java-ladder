package ladder.domain;

public class LadderReward {

  private final static String NUMBER_REGEX = "^[0-9]*$";
  private final static String LOSING_LADDER = "꽝";
  private final static String ILLEGAL_REWARD_MESSAGE = "금액 또는 꽝만 입력이 가능합니다. 현재 입력된 경품 : ";
  private final String ladderReward;

  public LadderReward(String ladderReward) {
    validateLadderReward(ladderReward);

    this.ladderReward = ladderReward;
  }

  public String reward() {
    return ladderReward;
  }

  private void validateLadderReward(String ladderReward) {
    if (!isLadderReward(ladderReward)) {
      throw new IllegalArgumentException(ILLEGAL_REWARD_MESSAGE + ladderReward);
    }
  }

  private boolean isLadderReward(String ladderReward) {
    return ladderReward.equals(LOSING_LADDER) || ladderReward.matches(NUMBER_REGEX);
  }
}
