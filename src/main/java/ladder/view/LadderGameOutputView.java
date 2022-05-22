package ladder.view;

import java.util.Scanner;
import ladder.domain.Connect;
import ladder.domain.GameResult;
import ladder.domain.GameResults;
import ladder.domain.GameUser;
import ladder.domain.GameUsers;
import ladder.domain.core.Ladder;
import ladder.domain.LadderGame;

public class LadderGameOutputView {

  public static final String SPACE = " ";
  public static final String DASH = "-";
  public static final String LADDER = "|";
  public static final String ALL = "all";
  public static final String LADDER_RESULT = "\n실행 결과";
  public static final String NOT_EXIST_USER_MSG = "존재하지 않는 사용자입니다.";
  private static final String RESULT_USER_INPUT_MESSAGE = "결과를 보고 싶은 사람은?";
  private static LadderGameOutputView instance;
  private final Scanner scanner;

  public static LadderGameOutputView getInstance() {
    if (instance == null) {
      instance = new LadderGameOutputView();
    }
    return instance;
  }

  private LadderGameOutputView() {
    this.scanner = new Scanner(System.in);
  }

  public void printLadderGame(LadderGame ladderGame) {
    System.out.println();
    printUsers(ladderGame.getGameUsers());

    Ladder ladder = ladderGame.getLadder();
    for (int height = 0; height < ladder.getLadderHeight(); height++) {
      printLadderLine(height, ladder);
    }

    printResults(ladderGame.getGameResults());
  }

  private void printResults(GameResults gameResults) {
    for (GameResult gameResult : gameResults.getValues()) {
      System.out.print(paddingLeftMaxLength(gameResult.getResult()));
    }
    System.out.println();
  }

  private void printUsers(GameUsers gameUsers) {
    for (int i = 0; i < gameUsers.getUserSize(); i++) {
      GameUser gameUser = gameUsers.getValues().get(i);
      System.out.print(paddingLeftMaxLength(gameUser.getName()));
    }
    System.out.println();
  }

  private String paddingLeftMaxLength(String target) {
    return SPACE.repeat(GameUser.LENGTH_LIMIT - target.length() + 1) + target;
  }

  private void printLadderLine(int heightIdx, Ladder ladder) {
    System.out.print(SPACE.repeat(GameUser.LENGTH_LIMIT));
    for (int lineIdx = 0; lineIdx < ladder.getWidth(); lineIdx++) {
      System.out.printf("%s%s", LADDER, getConnectLine(ladder.isRightConnect(heightIdx, lineIdx)));
    }
    System.out.println();
  }

  private String getConnectLine(boolean right) {
    if (right) {
      return DASH.repeat(GameUser.LENGTH_LIMIT);
    }
    return SPACE.repeat(GameUser.LENGTH_LIMIT);
  }

  public void printRepeatGameResult(LadderGame ladderGame) {
    while (true) {
      String resultUser = inputResultUser();
      System.out.println(LADDER_RESULT);
      if (resultUser.equals(ALL)) {
        printGameResultAll(ladderGame.getGameUsers(), ladderGame.getAllGameResult());
        return;
      }
      printGameResultOneUser(ladderGame.getUserGameResult(GameUser.from(resultUser)));
    }
  }

  private String inputResultUser() {
    System.out.println(RESULT_USER_INPUT_MESSAGE);
    return scanner.nextLine();
  }

  private void printGameResultOneUser(GameResult gameResult) {
    if (gameResult == null) {
      System.out.println(NOT_EXIST_USER_MSG);
      return;
    }
    System.out.println(gameResult.getResult());
  }


  private void printGameResultAll(GameUsers gameUsers, GameResults gameResults) {
    for (int i = 0; i < gameUsers.getUserSize(); i++) {
      System.out.printf("%s:%s\n", gameUsers.getValues().get(i).getName(),
          gameResults.getGameResult(i).getResult());
    }
  }
}
