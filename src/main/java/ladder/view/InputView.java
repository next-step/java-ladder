package ladder.view;

import java.util.Scanner;

public class InputView {
  private static final String INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String HEIGHT_INPUT_EVENT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public String nameInputEvent() {
    System.out.println(INPUT_MESSAGE);
    return scanner.nextLine();
  }

  public int heightInputEvent() {
    System.out.println(HEIGHT_INPUT_EVENT_MESSAGE);
    return scanner.nextInt();
  }
}
