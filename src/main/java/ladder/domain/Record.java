package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Record {
  private final Map<Player, Integer> values;

  private Record(Map<Player, Integer> values) {
    this.values = Collections.unmodifiableMap(values);
  }

  public static Record generate(Players players) {
    final List<Player> playersValues = players.getValues();
    Map<Player, Integer> result = playersValues.stream()
            .collect(Collectors.toMap(Function.identity(), playersValues::indexOf));
    return new Record(result);
  }

  public Record valueOf(final Ladder ladder) {
    Map<Player, Integer> copy = new HashMap<>(values)
            .keySet().stream()
            .collect(Collectors.toMap(Function.identity(),
                    key -> ladder.getLastDepthStartLineIndex(get(key))));
    return new Record(copy);
  }

  public int get(Player player) {
    return values.getOrDefault(player, 0);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Record that = (Record) o;
    return Objects.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "LadderResult{" +
            "values=" + values +
            '}';
  }
}
