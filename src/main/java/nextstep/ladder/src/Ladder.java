package nextstep.ladder.src;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
  private static final String SPACE = "     ";
  private static final int MIN_HEIGHT = 1;
  private static final int MIN_WIDTH = 1;
  
  private final List<Floor> ladder;

  public Ladder(List<Floor> ladder) {
    this.ladder = ladder;
  }

  public static Ladder makeLadderBySize(int height, int width) {
    checkSize(height, width);
    return new Ladder(
      IntStream.range(0,  height)
      .boxed()
      .map(i -> Floor.makeByWidht(width))
      .collect(Collectors.toList())
    );
  }

  public static void checkSize(int height, int width) {
    if(height < MIN_HEIGHT) {
      throw new IllegalArgumentException("height 은 1보다 작을수 없습니다.");
    }
    if(width < MIN_WIDTH) {
      throw new IllegalArgumentException("width 는 1보다 작을수 없습니다.");
    }
  }

  public String ui() {
    return ladder.stream()
      .map(floor -> SPACE + floor.ui())
      .collect(Collectors.joining("\n"));
  }
}
