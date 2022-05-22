package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final String DELIMITER = ",";

  private InputView() {
  }

  public static List<String> getNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    return Arrays.asList(getStringInput().split(DELIMITER));
  }

  public static int getHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return getIntInput();
  }

  public static List<String> getResults() {
    System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    return Arrays.asList(getStringInput().split(DELIMITER));
  }

  public static String getResultName() {
    System.out.println("결과를 보고 싶은 사람은?");
    return getStringInput();
  }

  private static int getIntInput() {
    return Integer.parseInt(SCANNER.nextLine());
  }

  private static String getStringInput() {
    return SCANNER.nextLine();
  }
}
