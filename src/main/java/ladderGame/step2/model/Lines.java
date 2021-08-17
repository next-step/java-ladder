package ladderGame.step2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

  private static final int INT_ZERO = 0;

  private final List<Line> lines;

  public Lines(final int height, final int playersCount) {
    this.lines = Collections.unmodifiableList(createLineLayer(height, playersCount));
  }

  public List<Line> toList() {
    return new ArrayList<>(lines);
  }

  public static List<Line> createLineLayer(int height, final int playerCount){
    return IntStream.range(INT_ZERO, height)
        .mapToObj(count -> new Line(playerCount))
        .collect(Collectors.toList());
  }
}