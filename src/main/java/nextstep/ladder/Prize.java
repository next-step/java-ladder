package nextstep.ladder;

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
  public String toString() {
    return name;
  }
}
