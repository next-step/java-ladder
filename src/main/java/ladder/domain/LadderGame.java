package ladder.domain;

public class LadderGame {

  private final GameInfo gameInfo;
  private final Ladder ladder;
  private static final String INVALID_HEIGHT = "높이는 양수여야합니다.";

  public LadderGame(int height, String[] userNames, String[] prizes) {
    this(new GameInfo(userNames, prizes), new Ladder(height, userNames.length));
    validateHeight(height);
  }

  public LadderGame(GameInfo gameInfo, Ladder ladder) {
    this.gameInfo = gameInfo;
    this.ladder = ladder;
  }

  private void validateHeight(int height) {
    if (height <= 0) {
      throw new IllegalArgumentException(INVALID_HEIGHT);
    }
  }

  public Ladder ladder() {
    return ladder;
  }

  public PrizeResult play() {

    PrizeResult prizeResult = new PrizeResult();
    int numberOfUsers = gameInfo.numberOfUsers();
    for (int index = 0; index < numberOfUsers; index++) {
      User user = gameInfo.findUserByIndex(index);
      Position finalPosition = ladder.goThroughLinesFrom(new Position(index));
      Prize prize = gameInfo.findPrizeByPosition(finalPosition);
      prizeResult.put(user, prize);
    }
    return prizeResult;
  }

  public GameInfo getGameInfo() {
    return gameInfo;
  }
}
