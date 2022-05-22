package view;

import java.util.Scanner;
import ladder.Height;
import ladder.Players;

public class LadderInputView {

  private static final String INPUT_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String INPUT_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

  private final Scanner scanner = new Scanner(System.in);

  public Players inputPlayerName() {
    String text = scanString(INPUT_NAME_MESSAGE);
    return Players.of(text);
  }

  public Height inputHeight() {
    return new Height(scanInt(INPUT_LADDER_HEIGHT));
  }

  private Integer scanInt(String description) {
    printDescription(description);
    return Integer.parseInt(scanner.nextLine());
  }

  private String scanString(String description) {
    printDescription(description);
    return scanner.nextLine();
  }

  private void printDescription(String description) {
    System.out.println(description);
  }
}
