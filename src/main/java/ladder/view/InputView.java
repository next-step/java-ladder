package ladder.view;

import java.util.Scanner;

public class InputView {
  private static final Scanner scanner = new Scanner(System.in);

  public static String participants() {
    printOutInputMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
    return inputLine();
  }

  public static String maxLadderHeight() {
    printOutInputMessage("최대 사다리 높이는 몇 개인가요?");
    return inputLine();
  }

  public static String prizes() {
    printOutInputMessage("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.)");
    return inputLine();
  }

  public static String wantResultOf() {
    printOutInputMessage("결과를 보고싶은 사람은?");
    return inputLine();
  }

  private static void printOutInputMessage(final String message) {
    System.out.println(message);
  }

  public static String inputLine() {
    return scanner.nextLine();
  }
}
