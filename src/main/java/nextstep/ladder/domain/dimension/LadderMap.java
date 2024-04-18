package nextstep.ladder.domain.dimension;

import nextstep.ladder.domain.generator.BooleanGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderMap implements TwoDimension {
  private List<Line> lines;
  private static final int MINIMUM_WIDTH = 1;
  private static final int MINIMUM_HEIGHT = 1;


public LadderMap(int width, int height, BooleanGenerator booleanGenerator) {
    validateWidth(width);
    validateHeight(height);
    this.lines = generateLines(width, height, booleanGenerator);
  }

  public LadderMap(List<Line> lines) {
    this.lines = lines;
  }

  private static List<Line> generateLines(int width, int height, BooleanGenerator booleanGenerator) {
    return IntStream.range(0, height).mapToObj(i -> new Line(width, booleanGenerator ))
        .collect(Collectors.toList());
  }

  private void validateWidth(int width) {
    if (width < MINIMUM_WIDTH) {
      throw new IllegalArgumentException("사다리의 너비는 1 이상이어야 합니다.");
    }
  }

  private void validateHeight(int height) {
    if (height < MINIMUM_HEIGHT) {
      throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
    }
  }

  public List<Line> getLine(){
  return lines;
  }

  @Override
  public int move(int index) {
    return lines.stream()
        .reduce(index, (idx, line) -> line.move(idx), (idx1, idx2) -> idx2);
  }

}
