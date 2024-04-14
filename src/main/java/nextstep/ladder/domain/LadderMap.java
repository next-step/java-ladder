package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderMap {
  private List<Line> lines;
  private final int MINIMUM_WIDTH = 1;
  private final int MINIMUM_HEIGHT = 1;


public LadderMap(Integer width, Integer height, BooleanGenerator booleanGenerator) {
    validateWidth(width);
    validateHeight(height);
    this.lines = generateLines(width, height, booleanGenerator);
  }

  private static List<Line> generateLines(Integer width, Integer height, BooleanGenerator booleanGenerator) {
    return IntStream.range(0, height).mapToObj(i -> new Line(width, booleanGenerator ))
        .collect(Collectors.toList());
  }

  private void validateWidth(Integer width) {
    if (width < MINIMUM_WIDTH) {
      throw new IllegalArgumentException("사다리의 너비는 1 이상이어야 합니다.");
    }
  }

  private void validateHeight(Integer height) {
    if (height < MINIMUM_HEIGHT) {
      throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
    }
  }

  public List<String> getLineStrings(){
    return lines.stream()
        .map(Line::getLineString)
        .collect(Collectors.toList());
  }

}
