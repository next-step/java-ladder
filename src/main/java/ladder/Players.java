package ladder;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

  public static final int MIN_PLAYER_NUMBER = 2;

  private static final String MESSAGE_FOR_INVALID_NAMES = "참가자 수는 %s이상 이어야합니다.";
  private static final String NAME_DELIMITER = ",";

  private final List<Name> names;

  Players(List<Name> names) {
    validateNames(names);
    this.names = names;
  }

  public int playerNumber() {
    return names.size();
  }

  public List<Name> playerNames() {
    return Collections.unmodifiableList(names);
  }

  public boolean isMoreThan(int number) {
    return playerNumber() > number;
  }

  public int startIndexOf(Name name) {
    return names.indexOf(name);
  }

  public boolean has(Name name) {
    return names.contains(name);
  }

  private void validateNames(List<Name> names) {
    if (names.size() < MIN_PLAYER_NUMBER) {
      throw new IllegalArgumentException(
          String.format(MESSAGE_FOR_INVALID_NAMES, MIN_PLAYER_NUMBER)
      );
    }
  }

  public static Players of(String text) {
    return new Players(Arrays.stream(text.split(NAME_DELIMITER))
        .map(String::strip)
        .map(Name::new)
        .collect(Collectors.toUnmodifiableList()));
  }
}
