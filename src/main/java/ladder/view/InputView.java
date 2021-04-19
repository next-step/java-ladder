package ladder.view;

import java.util.Scanner;

public class InputView {
  private static final String INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String PRIZE_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
  private static final String HEIGHT_INPUT_EVENT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
  private static final String CHECKER_MESSAGE = "결과를 보고 싶은 사람은?";

  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public String nameInputEvent() {
    System.out.println(INPUT_MESSAGE);
    return scanner.nextLine();
  }

  public String prizeInputEvent() {
    System.out.println(PRIZE_MESSAGE);
    return scanner.nextLine();
  }

  public int heightInputEvent() {
    System.out.println(HEIGHT_INPUT_EVENT_MESSAGE);
    return scanner.nextInt();
  }

  public String checkerEvent() {
    System.out.println(CHECKER_MESSAGE);
    return scanner.next();
  }
}
