package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ladder.constant.Constant;
import ladder.util.InputValidator;

public class NameStore {

  public static List<Name> createPlayers(String inputNames) {
    validateInputNames(inputNames);

    List<String> players = stringToList(inputNames);
    validateMinPlayers(players);

    return players.stream()
        .map(Name::new)
        .collect(Collectors.toList());
  }

  private static List<String> stringToList(String inputNames) {
    return Arrays.asList(splitString(inputNames));
  }

  private static String[] splitString(String inputNames) {
    return inputNames.split(Constant.REGEX);
  }

  private static void validateInputNames(String inputNames) {
    if (InputValidator.isEmptyOrBlank(inputNames)) {
      throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
    }
  }

  private static void validateMinPlayers(List<String> players) {
    if (players.size() < Constant.MIN_PLAYER) {
      throw new IllegalArgumentException("참가자는 최소 " + Constant.MIN_PLAYER + "명 이상이어야 합니다.");
    }
  }
}
