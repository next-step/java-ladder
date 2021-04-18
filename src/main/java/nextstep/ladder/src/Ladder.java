package nextstep.ladder.src;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
  private final List<Floor> ladder;

  public Ladder(List<Floor> ladder) {
    this.ladder = ladder;
  }

  public Ladder makeLadderBySize(int height, int width) {
    return new Ladder(
      IntStream.range(0,  height)
      .boxed()
      .map(i -> Floor.makeByWidht(width))
      .collect(Collectors.toList())
    );
  }
}
