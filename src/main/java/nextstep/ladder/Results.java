package nextstep.ladder;

import java.util.List;

public class Results {
  private final List<String> values;

  public Results(List<String> values) {
    this.values = values;
  }

  public String get(int index) {
    return values.get(index);
  }

  public List<String> values() {
    return values;
  }
}
