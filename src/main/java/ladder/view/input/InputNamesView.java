package ladder.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Name;
import ladder.domain.Participants;

public class InputNamesView extends InputView {

  private static final String DELIMITER = ",";

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

}
