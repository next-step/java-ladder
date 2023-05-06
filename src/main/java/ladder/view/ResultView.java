package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderLine;

import static ladder.utils.LadderUtil.*;

public class ResultView {

  public static void showLadder(LadderGame ladderGame) {
    System.out.println(RESULT_MESSAGE);

    ladderGame.users().forEach(user -> System.out.printf(USER_FIELD, user.name()));
    System.out.println();

    ladderGame.ladderLines().forEach(ResultView::showLadderLines);

    ladderGame.ladderRewards().forEach(ladderReward -> System.out.printf(USER_FIELD, ladderReward.reward()));
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
