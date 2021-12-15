package nextstep.ladder.domain.entity;

import java.util.Map;
import java.util.function.BiConsumer;

public class PrizeEntry {

  private final Map<String, Integer> map;

  public PrizeEntry(Map<String, Integer> map) {
    this.map = map;
  }

  public int findByName(String name) {
    return map.get(name);
  }

  public void forEach(BiConsumer<String, Integer> action) {
    map.forEach(action);
  }
}
