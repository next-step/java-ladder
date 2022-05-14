package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameResults {

  private static final String DELIMITER = ",";
  private final List<GameResult> values;

  private GameResults(List<GameResult> values) {
    this.values = values;
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
}
