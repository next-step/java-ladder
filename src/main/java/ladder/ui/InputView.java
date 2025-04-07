package ladder.ui;

import java.util.Scanner;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  private InputView() {}

  public static String readPlayerNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return scanner.nextLine();
  }

  public static int readHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return Integer.parseInt(scanner.nextLine());
  }
}
