package ladder.view;

import ladder.domain.GameResult;
import ladder.domain.GameResults;
import ladder.domain.GameUser;
import ladder.domain.GameUsers;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderPartLine;

public class LadderGameOutputView {

  public static final String SPACE = " ";
  public static final String DASH = "-";
  public static final String LADDER = "|";
  public static final String ALL = "all";
  public static final String LADDER_RESULT = "\n실행 결과";

  public static void printLadderGame(LadderGame ladderGame) {
    System.out.println();
    printUsers(ladderGame.getGameUsers());

    Ladder ladder = ladderGame.getLadder();
    for (int i = 0; i < ladder.getLadderHeight(); i++) {
      printLadderLine(ladder.getLadderLine(i));
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
      String userName = gameUsers.getUserName(i);
      System.out.print(paddingLeftMaxLength(userName));
    }
    System.out.println();
  }

  private static String paddingLeftMaxLength(String target) {
    return SPACE.repeat(GameUser.LENGTH_LIMIT - target.length() + 1) + target;
  }

  private static void printLadderLine(LadderPartLine ladderLine) {
    System.out.print(SPACE.repeat(GameUser.LENGTH_LIMIT));
    for (int i = 0; i < ladderLine.getLadderWidth(); i++) {
      System.out.printf("%s%s", LADDER, getConnectLine(ladderLine.isRightConnect(i)));
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
      printGameResultAll(ladderGame.getGameUsers(), ladderGame.gameResultAll());
      return;
    }
    printGameResultOneUser(ladderGame.gameResult(GameUser.from(resultUser)));
  }

  private static void printGameResultOneUser(GameResult gameResult) {
    System.out.println(gameResult.getResult());
  }


  private static void printGameResultAll(GameUsers gameUsers, GameResults gameResults) {
    for (int i = 0; i < gameUsers.getUserSize(); i++) {
      System.out.printf("%s:%s\n", gameUsers.getUserName(i),
          gameResults.getGameResult(i).getResult());
    }
    System.out.println();
  }
}
