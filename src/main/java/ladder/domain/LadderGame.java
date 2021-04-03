package ladder.domain;

public class LadderGame {

  private final GameInfo gameInfo;
  private final Lines lines;
  private static final String INVALID_HEIGHT = "높이는 양수여야합니다.";

  public LadderGame(int height, String[] userNames,String[] prizes) {
    this(new GameInfo(userNames, prizes), new Lines(height, userNames.length));
    validateHeight(height);
  }

  public LadderGame(GameInfo gameInfo, Lines lines) {
    this.gameInfo = gameInfo;
    this.lines = lines;
  }

  private void validateHeight(int height) {
    if (height <= 0) {
      throw new IllegalArgumentException(INVALID_HEIGHT);
    }
  }

  public Lines getLines() {
    return lines;
  }

  public PrizeResult play() {

    PrizeResult prizeResult = new PrizeResult();
    int numberOfUsers = gameInfo.numberOfUsers();
    for (int index = 0; index < numberOfUsers; index++) {
      User user = gameInfo.findPlayerByIndex(index);
      int finalPosition = lines.goThroughLinesFrom(index);
      Prize prize = gameInfo.findPrizeByPosition(finalPosition);
      prizeResult.put(user,prize);
    }
    return prizeResult;
  }

  public GameInfo getGameInfo() {
    return gameInfo;
  }
}
