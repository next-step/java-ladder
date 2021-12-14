package domain;

import common.Strings;

import static common.Constants.MAX_PLAYER_NAME_LENGTH;
import static common.ErrorMessages.NAME_IS_EMPTY;
import static common.ErrorMessages.NAME_IS_TOO_LONG;

public class Player {

  private String name;

  public Player(String name) {
    checkName(name);
    this.name = name;
  }

  private void checkName(String name) {
    checkBlank(name);
    checkLength(name);
  }

  private void checkBlank(String name) {
    if (Strings.isBlank(name)) {
      throw new IllegalArgumentException(NAME_IS_EMPTY);
    }
  }

  private void checkLength(final String name) {
    if (name.length() > MAX_PLAYER_NAME_LENGTH) {
      throw new IllegalArgumentException(NAME_IS_TOO_LONG);
    }
  }

  public String getName() {
    return name;
  }

}
