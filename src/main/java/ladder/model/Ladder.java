package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private static int MIN_SIZE = 1;

  List<Line> lines = new ArrayList<>();

  public Ladder(int height, int width) {
    validateSize(height, width);
    while (lines.size() < height) {
      lines.add(Line.randomLine(width));
    }
  }

  public List<Line> lines() {
    return lines;
  }

  private void validateSize(int height, int width) {
    if (height < MIN_SIZE || width < MIN_SIZE) {
      throw new IllegalArgumentException("사다리를 생성하기 위한 높이와 너비는 최소 " + MIN_SIZE + " 이상입니다.");
    }
  }
}
