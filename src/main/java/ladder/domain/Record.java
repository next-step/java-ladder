package ladder.domain;

import java.util.Collections;
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

  public static Record generate(final Players players, final Ladder ladder) {
    final List<Player> playersValues = players.getValues();

    Map<Player, Integer> result = playersValues.stream()
            .collect(Collectors.toMap(Function.identity(), player -> ladder.getLastDepthStartLineIndex(playersValues.indexOf(player))));
    return new Record(result);
  }

  public int getPlayerIndexOf(Player player) {
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
