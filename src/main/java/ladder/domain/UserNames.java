package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNames {

  private static final String DELIMITER = ",";
  private final List<UserName> value;

  private UserNames(String userNames) {
    this.value = Arrays.stream(userNames.split(DELIMITER))
        .map(UserName::of)
        .collect(Collectors.toList());
  }

  public static UserNames of(String userNames) {
    return new UserNames(userNames);
  }
}
