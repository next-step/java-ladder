package nextstep.ladder.io;

import java.util.Scanner;

public final class InputView {

  public static final String NAME_DELIMITER = ",";
  private static final Scanner SCANNER = new Scanner(System.in);

  private InputView() {}

  public static String[] inputNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
    return SCANNER.nextLine().replaceAll("\\s", "").split(NAME_DELIMITER);
  }

  public static int inputLadderHeight() {
    System.out.println();
    System.out.println("최대 사다리 높이는 몇인가요? (정수만 입력해주세요.)");
    return Integer.parseInt(SCANNER.nextLine());
  }
}
