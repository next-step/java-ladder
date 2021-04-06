package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

  private static final String INPUT_PERSON_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  private static final String INPUT_MAX_LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String DELIMITER = ",";
  private static final String INPUT_RESULT = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
  private static final String INPUT_RESULT_NAME = "결과를 보고 싶은 사람은?";

  public static String[] getPersonNames() {
    System.out.println(INPUT_PERSON_NAMES);
    String inputPersonNames = SCANNER.nextLine();
    return inputPersonNames.split(DELIMITER);
  }

  public static String[] getResult() {
    System.out.println(INPUT_RESULT);
    String inputResultString = SCANNER.nextLine();
    return inputResultString.split(DELIMITER);
  }

  public static int getLadderHeight() {
    System.out.println(INPUT_MAX_LADDER_HEIGHT);
    return Integer.parseInt(SCANNER.nextLine());
  }

  public static String getResultName() {
    System.out.println(INPUT_RESULT_NAME);
    return SCANNER.nextLine();
  }
}
