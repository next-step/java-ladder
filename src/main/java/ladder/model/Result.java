package ladder.model;

import java.util.HashMap;
import java.util.Map;

public class Result {

  private final Map<String, String> result;

  public Result() {
    this.result = new HashMap<>();
  }

  public void add(String name, String reward) {
    this.result.put(name, reward);
  }

  public String get(String name) {
    return this.result.get(name);
  }
}
