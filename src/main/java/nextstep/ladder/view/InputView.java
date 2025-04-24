package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
  private final Scanner scanner;

  public InputView(Scanner scanner) {
    this.scanner = scanner;
  }

  public String readPlayers() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return scanner.nextLine();
  }

  public int readLadderHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    try {
      return Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("사다리 높이는 숫자여야 합니다.");
    }
  }

  public String readResult() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    return scanner.nextLine();
  }

  public String readResultQuery() {
    System.out.println("결과를 보고 싶은 사람은?");
    return scanner.nextLine().trim();
  }
}
