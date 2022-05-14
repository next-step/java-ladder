package ladder.view;

import ladder.domain.GameUser;
import ladder.domain.GameUsers;
import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderLine;

public class LadderGameOutputView {

  public static final String SPACE = " ";
  public static final String DASH = "-";
  public static final String LADDER = "|";

  public static void printLadderGame(LadderGame ladderGame) {
    printUsers(ladderGame.getUserNames());

    Ladder ladder = ladderGame.getLadder();
    for (int i = 0; i < ladder.getLadderHeight(); i++) {
      printLadderLine(ladder.getLadderLine(i));
    }
  }

  private static void printUsers(GameUsers userNames) {
    for (int i = 0; i < userNames.getUserSize(); i++) {
      String userName = userNames.getUserName(i);
      System.out.print(paddingUserName(userName));
    }
    System.out.println();
  }

  private static String paddingUserName(String userName) {
    return SPACE.repeat(GameUser.LENGTH_LIMIT - userName.length() + 1) + userName;
  }

  private static void printLadderLine(LadderLine ladderLine) {
    System.out.print(SPACE.repeat(GameUser.LENGTH_LIMIT));
    for (int i = 0; i < ladderLine.getLadderWidth(); i++) {
      System.out.printf("%s%s", LADDER, getConnectLine(ladderLine.isConnect(i)));
    }
    System.out.println();
  }

  private static String getConnectLine(boolean connect) {
    if (connect) {
      return DASH.repeat(GameUser.LENGTH_LIMIT);
    }
    return SPACE.repeat(GameUser.LENGTH_LIMIT);
  }
}
