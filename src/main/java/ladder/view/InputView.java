package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.Height;
import ladder.domain.Name;
import ladder.domain.Participants;

public class InputView {

  private static final String DELIMITER = ",";
  private static final Scanner SCANNER = new Scanner(System.in);


  public static Participants scanPlayerNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    String totalNames = SCANNER.nextLine();
    String[] splitNames = splitNames(totalNames);
    List<Name> names = toNames(splitNames);
    return new Participants(names);
  }

  private static String[] splitNames(String names) {
    return names.split(DELIMITER);
  }

  private static List<Name> toNames(String[] splitNames) {
    return Arrays.stream(splitNames)
        .map(Name::new)
        .collect(Collectors.toList());
  }


  public static Height scanLadderHeight() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    String height = SCANNER.nextLine();
    validateIsNumber(height);
    return new Height(parseInt(height));
  }

  private static void validateIsNumber(String height) {
    if(isNotNumber(height)){
      throw new IllegalArgumentException("숫자만 입력 가능합니다.");
    }
  }

  private static boolean isNotNumber(String height) {
    return !height.matches("^[0-9]*$");
  }

  private static int parseInt(String height) {
    return Integer.parseInt(height);
  }
}
