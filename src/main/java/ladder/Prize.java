package ladder;

import java.util.Objects;

public class Prize {

  private final Name prizeName;

  public Prize(String name) {
    this(new Name(name));
  }

  Prize(Name name) {
    this.prizeName = name;
  }

  @Override
  public String toString() {
    return prizeName.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Prize prize = (Prize) o;
    return prizeName.equals(prize.prizeName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prizeName);
  }
}
