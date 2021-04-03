package ladder.view;

import java.util.Scanner;

public class InputView {

  private Scanner scanner = new Scanner(System.in);
  private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String INPUT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

  public String[] inputNames() {
    System.out.println(INPUT_NAMES);
    return scanner.nextLine().split(",");
  }

  public int inputHeight() {
    System.out.println(INPUT_HEIGHT);
    return scanner.nextInt();
  }

  public String[] inputPrizes() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    return scanner.nextLine().split(",");
  }

  public String inputResult() {
    System.out.println("결과를 보고 싶은 사람은?(게임을 종료하려면 -1을 입력하시고 전체 결과를 보려면 all을 입력하세요.");
    return scanner.next();
  }
}
