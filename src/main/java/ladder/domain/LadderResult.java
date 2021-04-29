package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LadderResult {
  private final Map<Player, Integer> values;

  private LadderResult(Map<Player, Integer> values) {
    this.values = Collections.unmodifiableMap(values);
  }

  public static LadderResult generate(Players players) {
    final List<Player> playersValues = players.getValues();
    Map<Player, Integer> result = playersValues.stream()
            .collect(Collectors.toMap(Function.identity(), playersValues::indexOf));
    return new LadderResult(result);
  }

  public LadderResult run(Ladder ladder) {
    Map<Player, Integer> copy = new HashMap<>();
    copy.putAll(values);

    for (Player key : copy.keySet()) {
      for (Depth depth : ladder.getDepth()) {
        copy.put(key, getNextDepthStartIndex(depth, get(key)));
      }
    }

    return new LadderResult(copy);
  }

  private static int getNextDepthStartIndex(Depth depth, int i) {
    final int indexOfLeftLine = i - 1;
    final int indexOfRightLine = i;

    List<Line> lines = depth.getValues();
    boolean existOfLeft = existLine(lines, indexOfLeftLine);
    boolean existOfRight = existLine(lines, indexOfRightLine);

    if (existOfLeft) {
      return --i;
    }

    if (existOfRight) {
      return ++i;
    }

    return i;
  }

  private static boolean existLine(List<Line> lines, int i) {
    final int firstLineIndex = 0;
    boolean isValidLineIndexBounds = firstLineIndex <= i && i < lines.size();
    if (isValidLineIndexBounds) {
      return !lines.get(i).isEmpty();
    }
    return false;
  }

  public int get(Player player) {
    return values.getOrDefault(player, 0);
  }

  public Map<Player, Integer> getValues() {
    return values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LadderResult that = (LadderResult) o;
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
