package nextstep.ladder.domain;

import java.util.Objects;

public class PlayerName {

  private static final int MIN_LEN = 1;
  private static final int MAX_LEN = 5;
  private static final String ALL = "all";

  private final String name;

  public PlayerName(String name) {
    validate(name);
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public boolean isAll() {
    return this.name.equals(ALL);
  }

  private void validate(String name) {
    if (name.length() < MIN_LEN || name.length() > MAX_LEN) {
      throw new IllegalArgumentException(String.format("이름의 길이는 %d ~ %d글자 사이어야 합니다. 입력된 값 : %s", MIN_LEN, MAX_LEN, name));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlayerName that = (PlayerName) o;
    return Objects.equals(getName(), that.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }
}
