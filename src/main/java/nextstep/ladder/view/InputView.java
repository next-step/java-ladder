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

  private static int getIntInput() {
    return SCANNER.nextInt();
  }

  private static String getStringInput() {
    return SCANNER.nextLine();
  }
}
