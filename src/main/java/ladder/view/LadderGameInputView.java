package ladder.view;

import java.util.Scanner;

public class LadderGameInputView {

  private static final String USER_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
  private static final String RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";

  private final Scanner scanner;

  public LadderGameInputView() {
    this.scanner = new Scanner(System.in);
  }

  public String getLadderUsers() {
    System.out.println(USER_INPUT_MESSAGE);
    return scanner.nextLine();
  }

  public int getLadderHeight() {
    System.out.println(HEIGHT_INPUT_MESSAGE);
    int ladderHeight = scanner.nextInt();
    scanner.nextLine();
    return ladderHeight;
  }

  public String getGameResults() {
    System.out.println(RESULT_INPUT_MESSAGE);
    return scanner.nextLine();
  }

}
