package ladder;

import java.util.Objects;

public class Player {

  private static final int DEFAULT_PLAYERS_NAME_FORMAT_LENGTH = 6;
  public static final int NAME_LIMIT_LENGTH = 5;
  public static final String NAME_BLANK_SYMBOL = " ";

  String name;

  public Player(String name) {
    if (name.length() > NAME_LIMIT_LENGTH) {
      throw new IllegalArgumentException("이름은 다섯글자 이하여야 합니다.");
    }
    this.name = name;
  }

  public int nameLength() {
    return name.length();
  }

  private boolean isGreater(int length) {
    return name.length() >= length;
  }

  private String addBlank(int length) {
    StringBuffer blankBuffer = new StringBuffer();
    for (int i = 0; i < length; i++) {
      blankBuffer.append(NAME_BLANK_SYMBOL);
    }
    return blankBuffer.toString();
  }

  @Override
  public String toString() {
    if (isGreater(DEFAULT_PLAYERS_NAME_FORMAT_LENGTH)) {
      return name;
    }
    return name + addBlank(DEFAULT_PLAYERS_NAME_FORMAT_LENGTH - name.length());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

}
