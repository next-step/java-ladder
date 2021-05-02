package ladder.view;

import java.util.Scanner;

public final class InputView {
  public static final String FIND_ALL_KEYWORD = "all";

  private static final Scanner SCANNER;
  private static final String PLAYERS_INPUT_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String EXECUTE_RESULT_INPUT_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
  private static final String HEIGHT_INPUT_QUESTION = "최대 사다리 높이는 몇 개인가요?";
  private static final String LADDER_RESULT_RECORD_OF_PLAYER_QUESTION = "결과를 보고 싶은 사람은?";

  static {
    SCANNER = new Scanner(System.in);
  }

  private InputView() {
  }

  public static String getPlayerNames() {
    System.out.println(PLAYERS_INPUT_QUESTION);
    return SCANNER.nextLine();
  }

  public static int getHeight() {
    System.out.println(HEIGHT_INPUT_QUESTION);
    return Integer.parseInt(SCANNER.nextLine());
  }

  public static String getResult() {
    System.out.println(EXECUTE_RESULT_INPUT_QUESTION);
    return SCANNER.nextLine();
  }

  public static String getResultByKeyword() {
    System.out.println(LADDER_RESULT_RECORD_OF_PLAYER_QUESTION);
    return SCANNER.nextLine();
  }
}
