package ladder.view;

import ladder.domain.Players;

import java.util.Scanner;

public final class InputView {
  private static final Scanner SCANNER;
  private static final String PLAYERS_INPUT_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String HEIGHT_INPUT_QUESTION = "최대 사다리 높이는 몇 개인가요?";

  static {
    SCANNER = new Scanner(System.in);
  }

  private InputView() {
  }

  public static Players playerNames() {
    System.out.println(PLAYERS_INPUT_QUESTION);
    return Players.create(SCANNER.nextLine());
  }

  public static int height() {
    System.out.println(HEIGHT_INPUT_QUESTION);
    return SCANNER.nextInt();
  }


}
