package nextstep.laddergame.domain;

import java.util.Objects;

public class Name {
  private final String name;

  public Name(String name) {
    validate(name);
    this.name = name;
  }


  private void validate(String memberName) {
    hasNull(memberName);
  }

  private void hasNull(String memberName) {
    if(memberName == null || memberName.trim().length() == 0) {
      throw new IllegalArgumentException("ERROR : 이름에는 Null을 포함할 수 없습니다.");
    }
  }

  public String name() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Name)) {
      return false;
    }
    Name name1 = (Name) o;
    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
