package ladder.domain;

import java.util.List;

public class Prizes {
  private final List<Prize> values;

  public Prizes(final List<Prize> values) {
    this.values = values;
  }

  public Prize prizeAt(final int index) {
    return this.values.get(index);
  }
}
