package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameResults {

  private static final String DELIMITER = ",";
  private final List<GameResult> values;

  public GameResults(List<GameResult> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static GameResults from(String gameResults) {
    List<GameResult> values = Arrays.stream(gameResults.split(DELIMITER))
        .map(s -> GameResult.from(s))
        .collect(Collectors.toList());

    return new GameResults(values);
  }

  public int getResultSize() {
    return values.size();
  }

  public List<GameResult> getValues() {
    return values;
  }

  public GameResult getGameResult(int width) {
    return values.get(width);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof GameResults)) {
      return false;
    }
    GameResults that = (GameResults) o;
    return Objects.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }
}
