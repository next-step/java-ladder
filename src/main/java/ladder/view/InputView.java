package ladder.view;

import java.util.Scanner;

public class InputView {

  public static String inputPlayerName() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return new Scanner(System.in).nextLine();
  }

  public static int inputHeight() {
    System.out.println("\n최대 사다리 높이는 몇 개인가요?");
    return new Scanner(System.in).nextInt();
  }
}
