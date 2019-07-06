package ladder.model;

import java.util.HashMap;
import java.util.Iterator;
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
    if (!this.result.containsKey(name)) {
      throw new IllegalArgumentException("입력하신 Player가 없습니다.");
    }

    return this.result.get(name);
  }

  public Iterator<String> getAll() {
    return result.keySet().iterator();
  }

  @Override
  public String toString() {
    return "Result{" +
            "result=" + result +
            '}';
  }
}
