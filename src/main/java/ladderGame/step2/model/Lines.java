package ladderGame.step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

  private static final int INDEX_START = 0;

  private static final int LIMIT_HEIGHT_VALUE = 1;

  private static final String MSG_ERROR_LIMIT_HEIGHT = "높이값은 최소 1부터 가능합니다.";

  private final List<Line> lines;

  public Lines(final int height, final int playersCount) {
    this.lines = Collections.unmodifiableList(createLineLayer(height, playersCount));
  }

  public List<Line> toList() {
    return new ArrayList<>(lines);
  }

  public static List<Line> createLineLayer(int height, final int playerCount) {
    validateHeight(height);
    return IntStream.range(INDEX_START, height)
        .mapToObj(count -> new Line(playerCount))
        .collect(Collectors.toList());
  }

  private static void validateHeight(int height) {
    if (height < LIMIT_HEIGHT_VALUE) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_HEIGHT);
    }
  }
}