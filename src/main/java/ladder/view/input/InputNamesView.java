package ladder.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.participant.Name;
import ladder.domain.participant.Participants;

public class InputNamesView extends InputView {

  private static final String DELIMITER = ",";
  private static final String ALL = "all";

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

  public static Name scanPlayerName(Participants participants) {
    System.out.println("결과를 보고 싶은 사람은?");
    String inputName = SCANNER.nextLine();
    Name name = new Name(inputName);
    validateName(participants, name);
    return name;
  }

  private static void validateName(Participants participants, Name name) {
    if (hasNotName(participants, name)) {
      throw new IllegalArgumentException("존재하지 않는 이름입니다.");
    }
  }

  private static boolean hasNotName(Participants participants, Name name) {
    return !name.isAll() && !participants.containsName(name);
  }
}
