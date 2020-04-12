package nextstep.ladder.model;

import java.util.Objects;

public class Name {

  private String name;

  public Name(String name) {
    throwIfInvalid(name);

    this.name = name;
  }

  private void throwIfInvalid(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("6글자 넘는 이름은 생성할 수 없습니다.");
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
    return name.equals(name1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
