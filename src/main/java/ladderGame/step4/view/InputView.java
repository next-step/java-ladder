package ladderGame.step4.view;

import java.util.Scanner;

public class InputView {

  private static final String MSG_INSERT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

  private static final String MSG_INSERT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

  private static final String MSG_INSERT_GOODS = "실행 결과를 입력하세요. (결과는 (,)로 구분하세요)";

  private static final String MSG_INSERT_FIND_NAMES = "결과를 보고 싶은 사람은?";

  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {
  }

  public static String inputUserNames() {
    System.out.println(MSG_INSERT_PLAYER_NAMES);
    return scanner.nextLine();
  }

  public static int inputLadderHeight() {
    System.out.println(MSG_INSERT_HEIGHT);
    return Integer.parseInt(scanner.nextLine());
  }

  public static String inputGoods() {
    System.out.println(MSG_INSERT_GOODS);
    return scanner.nextLine();
  }

  public static String inputFindNames() {
    System.out.println(MSG_INSERT_FIND_NAMES);
    return scanner.nextLine();
  }
}