package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderLine;

public class ResultView {

  private static final String CONNECTION = "-----";
  private static final String DISCONNECTION = "     ";
  private static final String SINGLE_POINT = "|";

  public static void showLadder(LadderGame ladderGame) {
    System.out.println("실행 결과");

    ladderGame.users().forEach(user -> System.out.printf("%5s ", user.name()));
    System.out.println();

    ladderGame.ladderLines().forEach(ResultView::showLadderLines);
  }

  private static void showLadderLines(LadderLine ladderLine) {
    ladderLine.points().forEach(point -> System.out.print(connection(point.canMovePrevious()) + SINGLE_POINT));
    System.out.println();
  }

  private static String connection(boolean movable) {
    if (movable) {
      return CONNECTION;
    }

    return DISCONNECTION;
  }
}
