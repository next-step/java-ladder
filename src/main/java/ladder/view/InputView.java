package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import ladder.domain.Name;

public class InputView {

  private static final String DELIMITER = ",";
  private static final Scanner SCANNER = new Scanner(System.in);


  public static List<Name> scanPlayerNames() {
    System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    String totalNames = SCANNER.nextLine();
    String[] splitNames = splitNames(totalNames);
    return toNames(splitNames);
  }

  private static String[] splitNames(String names) {
    return names.split(DELIMITER);
  }

  private static List<Name> toNames(String[] splitNames) {
    return Arrays.stream(splitNames)
        .map(Name::new)
        .collect(Collectors.toList());
  }



}
