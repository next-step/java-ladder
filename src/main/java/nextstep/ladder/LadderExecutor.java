package nextstep.ladder;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderExecutor implements Executor {
  private final Ladder ladder;
  private final Mapping mapping;

  public LadderExecutor(Ladder ladder, Mapping mapping) {
    this.ladder = ladder;
    this.mapping = mapping;
  }

  @Override
  public String execute(String name) {
    int start = mapping.indexOf(name);
    int end = ladder.move(start);
    return mapping.resultOfIndex(end);
  }

  @Override
  public Map<String, String> executeAll() {
    Map<String, String> result = new LinkedHashMap<>();
    for (String name : mapping.names()) {
      result.put(name, execute(name));
    }
    return result;
  }
}
