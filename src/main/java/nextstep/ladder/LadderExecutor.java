package nextstep.ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderExecutor {
  private final Ladder ladder;
  private final MappingTable table;

  public LadderExecutor(Ladder ladder, MappingTable table) {
    this.ladder = ladder;
    this.table = table;
  }

  public String resultOf(String name) {
    int start = table.indexOf(name);
    int end = ladder.move(start);
    return table.resultAt(end);
  }

  public Map<String, String> allResults() {
    return table.names().stream()
        .collect(
            LinkedHashMap::new,
            (map, name) -> map.put(name, resultOf(name)),
            Map::putAll
        );
  }
}
