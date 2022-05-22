package ladder;

import static ladder.PlayerNumber.MIN_PLAYER_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {

  private static final String MESSAGE_FOR_INVALID_NAMES = "참가자 수는 %s이상 이어야합니다.";
  private static final String MESSAGE_FOR_INVALID_NAME = "참가자 이름은 %s글자 이내여야 합니다.";
  private static final String NAME_DELIMITER = ",";
  private static final int MAX_NAME_LENGTH = 5;

  private final List<String> names;

  PlayerNames(List<String> names) {
    validateNames(names);
    this.names = names;
  }

  public int playerNumber() {
    return names.size();
  }

  public List<String> playerNames() {
    return names.stream()
        .collect(Collectors.toUnmodifiableList());
  }

  private void validateNames(List<String> names) {
    if (names.size() < MIN_PLAYER_NUMBER) {
      throw new IllegalArgumentException(
          String.format(MESSAGE_FOR_INVALID_NAMES, MIN_PLAYER_NUMBER)
      );
    }

    if (names.stream()
        .anyMatch(name -> name.length() > MAX_NAME_LENGTH)) {
      throw new IllegalArgumentException(String.format(MESSAGE_FOR_INVALID_NAME, MAX_NAME_LENGTH));
    }
  }

  public static PlayerNames of(String text) {
    return new PlayerNames(Arrays.stream(text.split(NAME_DELIMITER))
        .map(String::strip)
        .collect(Collectors.toUnmodifiableList()));
  }
}
