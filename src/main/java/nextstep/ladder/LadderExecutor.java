package nextstep.ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    return mapping.names().stream()
        .collect(Collectors.toMap(
            name -> name,
            this::execute,
            (a, b) -> b,
            LinkedHashMap::new
        ));
  }
}
