package ladder.view;

import java.util.Scanner;

public class InputView {

  private Scanner scanner = new Scanner(System.in);
  private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String COMMA = ",";
  private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

  public String[] inputNames() {
    System.out.println(INPUT_NAMES);
    String names = scanner.nextLine();
    return names.split(COMMA);
  }

  public int inputHeight() {
    System.out.println(INPUT_HEIGHT);
    return scanner.nextInt();
  }
}
