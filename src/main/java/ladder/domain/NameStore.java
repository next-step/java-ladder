package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ladder.constant.Constant;

public class NameStore {

  public static List<Name> createPlayers(String inputNames) {
    return stringToList(inputNames).stream()
        .map(Name::new)
        .collect(Collectors.toList());
  }

  private static List<String> stringToList(String inputNames) {
    return Arrays.asList(splitString(inputNames));
  }

  private static String[] splitString(String inputNames) {
    return inputNames.split(Constant.REGEX);
  }
}
