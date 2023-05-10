package ladder.view;

import ladder.domain.*;

import static ladder.utils.LadderUtil.*;

public class ResultView {

  public static void showLadder(LadderGame ladderGame, LadderRewards ladderRewards) {
    System.out.println(LADDER_RESULT_MESSAGE);

    ladderGame.users().forEach(user -> System.out.printf(USER_FIELD, user.name()));
    System.out.println();

    ladderGame.ladderLines().forEach(ResultView::showLadderLines);

    ladderRewards.ladderRewards().forEach(ladderReward -> System.out.printf(USER_FIELD, ladderReward.reward()));
    System.out.println();
  }

  public static void showResult(LadderResult ladderResult) {
    boolean continueGame = true;

    while (continueGame) {
      System.out.println(USER_INPUT_MESSAGE);
      String userName = InputView.inputUserName();

      continueGame = isContinueGame(userName);

      showResultReward(userName, ladderResult);
    }
  }

  private static boolean isContinueGame(String userName) {
    return !userName.equalsIgnoreCase(END_GAME);
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
    if (!isContinueGame(userName)) {
      System.out.println(END_GAME_MESSAGE);
      return;
    }

    if (userName.equals(ALL_USERS)) {
      System.out.println(REWARD_RESULT_MESSAGE);
      printUserAndReward(ladderResult);
      return;
    }

    System.out.println(REWARD_RESULT_MESSAGE);
    System.out.println(rewardOrNone(ladderResult.rewardOfUser(userName)));
  }

  private static void printUserAndReward(LadderResult ladderResult) {
    ladderResult.users().forEach(user -> {
      System.out.printf(REWARD_OF_USER, user.name(), rewardOrNone(ladderResult.rewardOfUser(user.name())));
      System.out.println();
    });
  }

  private static String rewardOrNone(LadderReward ladderReward) {
    if (ladderReward == null) {
      return NONE_USER;
    }
    return ladderReward.reward();
  }
}
