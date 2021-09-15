package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private static int MIN_HEIGHT = 1;
  private static int MIN_WIDTH = 1;

  private final List<LadderLine> ladderLines = new ArrayList<>();

  public Ladder(int height, int width) {
    validateSize(height, width);
    while (ladderLines.size() < height) {
      ladderLines.add(LadderLine.randomLadderLine(width));
    }
  }

  public boolean isExistFoothold(int heightIdx, int widthIdx) {
    return ladderLines.get(heightIdx).isExistFoothold(widthIdx);
  }

  public int getHeight() {
    return ladderLines.size();
  }

  public int getWidth() {
    return ladderLines.get(0).getSize();
  }

  private void validateSize(int height, int width) {
    if (height < MIN_HEIGHT) {
      throw new IllegalArgumentException("사다리를 생성하기 위한 최소 높이는 " + MIN_HEIGHT + " 입니다.");
    }
    if (width < MIN_WIDTH) {
      throw new IllegalArgumentException("사다리를 생성하기 위한 최소 너비는 " + MIN_WIDTH + " 입니다.");
    }
  }
}
