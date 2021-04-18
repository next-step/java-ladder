package nextstep.ladder.src;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
  private static final String SPACE = "     ";
  
  private final List<Floor> ladder;

  public Ladder(List<Floor> ladder) {
    this.ladder = ladder;
  }

  public static Ladder makeLadderBySize(int height, int width) {
    return new Ladder(
      IntStream.range(0,  height)
      .boxed()
      .map(i -> Floor.makeByWidht(width))
      .collect(Collectors.toList())
    );
  }

  public String ui() {
    return ladder.stream()
      .map(floor -> SPACE + floor.ui())
      .collect(Collectors.joining("\n"));
  } 
}
