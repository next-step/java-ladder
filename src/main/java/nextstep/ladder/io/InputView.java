package nextstep.ladder.io;

import java.util.Scanner;

public final class InputView {

  public static final String INPUT_DELIMITER = ",";
  public static final String SPACE_REGEX = "\\s";
  public static final String EMPTY_STRING = "";
  private static final Scanner SCANNER = new Scanner(System.in);

  private InputView() {}

  public static String[] inputNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
    return splitInput();
  }

  public static String[] inputResults() {
    System.out.println();
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요.)");
    return splitInput();
  }

  private static String[] splitInput() {
    return SCANNER.nextLine().replaceAll(SPACE_REGEX, EMPTY_STRING).split(INPUT_DELIMITER);
  }

  public static int inputLadderHeight() {
    System.out.println();
    System.out.println("최대 사다리 높이는 몇인가요? (정수만 입력해주세요.)");
    return Integer.parseInt(SCANNER.nextLine());
  }

  public static String inputPersonNameForResult() {
    System.out.println();
    System.out.println("결과를 보고 싶은 사람은?");
    return SCANNER.nextLine();
  }
}
