package ladder.domain;

import java.util.Objects;
import ladder.constant.Constant;

public class Name {

  private final String name;

  public Name(String name) {
    validateName(name);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  private void validateName(String name) {
    if (name.length() > Constant.MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
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

    Name name1 = (Name) o;

    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
