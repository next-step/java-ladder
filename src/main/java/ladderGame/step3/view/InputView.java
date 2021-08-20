package ladderGame.step3.view;

import java.util.Scanner;

public class InputView {

  private static final String MSG_INSERT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

  private static final String MSG_INSERT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

  private static Scanner scanner = new Scanner(System.in);

  public static String inputUserNames() {
    System.out.println(MSG_INSERT_PLAYER_NAMES);
    return scanner.nextLine();
  }

  public static int inputLadderHeight() {
    System.out.println(MSG_INSERT_HEIGHT);
    return scanner.nextInt();
  }
}