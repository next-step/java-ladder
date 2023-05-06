package ladder.view;

import ladder.domain.LadderGame;
import ladder.domain.LadderLine;
import ladder.domain.LadderResult;
import ladder.domain.LadderReward;

import static ladder.utils.LadderUtil.*;

public class ResultView {

  public static void showLadder(LadderGame ladderGame) {
    System.out.println(LADDER_RESULT_MESSAGE);

    ladderGame.users().forEach(user -> System.out.printf(USER_FIELD, user.name()));
    System.out.println();

    ladderGame.ladderLines().forEach(ResultView::showLadderLines);

    ladderGame.ladderRewards().forEach(ladderReward -> System.out.printf(USER_FIELD, ladderReward.reward()));
    System.out.println();
  }

  public static void showResult(LadderResult ladderResult) {
    while (true) {
      System.out.println(USER_INPUT_MESSAGE);
      String userName = InputView.inputUserName();

      if (userName.equalsIgnoreCase(END_GAME)) {
        break;
      }

      showResultReward(userName, ladderResult);
    }
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

  private static void showResultReward(String userName, LadderResult ladderResult) {
    if (userName.equals(ALL_USERS)) {
      System.out.println(REWARD_RESULT_MESSAGE);
      ladderResult.users().forEach(user -> {
        System.out.printf(REWARD_OF_USER, user.name(), rewardOrNone(ladderResult.rewardOfUser(user.name())));
        System.out.println();
      });
      return;
    }

    System.out.println(REWARD_RESULT_MESSAGE);
    System.out.println(rewardOrNone(ladderResult.rewardOfUser(userName)));
  }

  private static String rewardOrNone(LadderReward ladderReward) {
    if (ladderReward == null) {
      return NONE_USER;
    }
    return ladderReward.reward();
  }
}
