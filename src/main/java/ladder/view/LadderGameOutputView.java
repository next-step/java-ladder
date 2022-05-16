package ladder.view;

import ladder.domain.GameResult;
import ladder.domain.GameResults;
import ladder.domain.GameUser;
import ladder.domain.GameUsers;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;

public class LadderGameOutputView {

  public static final String SPACE = " ";
  public static final String DASH = "-";
  public static final String LADDER = "|";
  public static final String ALL = "all";
  public static final String LADDER_RESULT = "\n실행 결과";
  public static final String NOT_EXIST_USER_MSG = "존재하지 않는 사용자입니다.";

  public static void printLadderGame(LadderGame ladderGame) {
    System.out.println();
    printUsers(ladderGame.getGameUsers());

    Ladder ladder = ladderGame.getLadder();
    for (int height = 0; height < ladder.getLadderHeight(); height++) {
      printLadderLine(height, ladder);
    }

    printResults(ladderGame.getGameResults());
  }

  private static void printResults(GameResults gameResults) {
    for (GameResult gameResult : gameResults.getValues()) {
      System.out.print(paddingLeftMaxLength(gameResult.getResult()));
    }
    System.out.println();
  }

  private static void printUsers(GameUsers gameUsers) {
    for (int i = 0; i < gameUsers.getUserSize(); i++) {
      GameUser gameUser = gameUsers.getValues().get(i);
      System.out.print(paddingLeftMaxLength(gameUser.getName()));
    }
    System.out.println();
  }

  private static String paddingLeftMaxLength(String target) {
    return SPACE.repeat(GameUser.LENGTH_LIMIT - target.length() + 1) + target;
  }

  private static void printLadderLine(int height, Ladder ladder) {
    System.out.print(SPACE.repeat(GameUser.LENGTH_LIMIT));
    for (int width = 0; width < ladder.getLadderWidth(); width++) {
      System.out.printf("%s%s", LADDER, getConnectLine(ladder.isRightConnect(height, width)));
    }
    System.out.println();
  }

  private static String getConnectLine(boolean connect) {
    if (connect) {
      return DASH.repeat(GameUser.LENGTH_LIMIT);
    }
    return SPACE.repeat(GameUser.LENGTH_LIMIT);
  }

  public static void printGameResult(String resultUser, LadderGame ladderGame) {
    System.out.println(LADDER_RESULT);
    if (resultUser.equals(ALL)) {
      printGameResultAll(ladderGame.getGameUsers(), ladderGame.getAllGameResult());
      return;
    }
    printGameResultOneUser(ladderGame.getUserGameResult(GameUser.from(resultUser)));
  }

  private static void printGameResultOneUser(GameResult gameResult) {
    if (gameResult == null) {
      System.out.println(NOT_EXIST_USER_MSG);
      return;
    }
    System.out.println(gameResult.getResult());
  }


  private static void printGameResultAll(GameUsers gameUsers, GameResults gameResults) {
    for (int i = 0; i < gameUsers.getUserSize(); i++) {
      System.out.printf("%s:%s\n", gameUsers.getValues().get(i).getName(),
          gameResults.getGameResult(i).getResult());
    }
  }
}
