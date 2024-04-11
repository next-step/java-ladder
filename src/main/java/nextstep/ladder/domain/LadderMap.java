package nextstep.ladder.domain;

import java.util.List;

public class LadderMap {
  List<Line> lines;

public LadderMap(Integer width, Integer height) {
  validateWidth(width);
    validateHeight(height);
  }

  public LadderMap(List<Line> lines) {
    this.lines = lines;
  }

  private void validateWidth(Integer width) {
    if (width < 1) {
      throw new IllegalArgumentException("사다리의 너비는 1 이상이어야 합니다.");
    }
  }

  private void validateHeight(Integer height) {
    if (height < 1) {
      throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
    }
  }

}
