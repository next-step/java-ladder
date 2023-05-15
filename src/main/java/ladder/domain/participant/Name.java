package ladder.domain.participant;

import java.util.Objects;

public class Name {

  private static final String ALL = "all";
  private final String name;

  public Name(String name) {
    validateLength(name);
    this.name = name;
  }

  private void validateLength(String name) {
    if (isOverLength(name)){
      throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
    }
  }

  private boolean isOverLength(String name) {
    return name.length() > 5;
  }

  public String name() {
    return name;
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
    return Objects.hash(name);
  }

  public boolean isAll() {
    return name.equals(ALL);
  }
}
