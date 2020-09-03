package nextstep.ladder;

import java.util.Objects;

public class Prize {
  private final String name;
  private final int location;

  public Prize(String name, int location) {
    this.name = name;
    this.location = location;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Prize prize = (Prize) o;
    return location == prize.location &&
            Objects.equals(name, prize.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, location);
  }

  @Override
  public String toString() {
    return name;
  }
}
