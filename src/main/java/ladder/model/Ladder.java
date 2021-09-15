package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private static int MIN_HEIGHT = 1;
  private static int MIN_WIDTH = 2;

  private final List<LadderLine> ladderLines;

  public Ladder(int height, int width) {
    this(randomLadderLines(height, width));
  }

  public Ladder(List<LadderLine> ladderLines) {
    validateLadderLines(ladderLines);
    this.ladderLines = ladderLines;
  }

  public int resultPositionOf(int position) {
    for (LadderLine ladderLine : ladderLines) {
      position = ladderLine.nextPosition(position);
    }
    return position;
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

  private static List<LadderLine> randomLadderLines(int height, int width) {
    List<LadderLine> ladderLines = new ArrayList<>();
    while (ladderLines.size() < height) {
      ladderLines.add(LadderLine.randomLadderLine(width));
    }
    return ladderLines;
  }

  private void validateLadderLines(List<LadderLine> ladderLines) {
    if (ladderLines.size() < MIN_HEIGHT) {
      throw new IllegalArgumentException("사다리를 생성하기 위한 최소 높이는 " + MIN_HEIGHT + " 입니다.");
    }
    if (ladderLines.get(0).getSize() < MIN_WIDTH) {
      throw new IllegalArgumentException("사다리를 생성하기 위한 최소 너비는 " + MIN_WIDTH + " 입니다.");
    }
    if (ladderLines.stream().mapToInt(LadderLine::getSize).distinct().count() != 1) {
      throw new IllegalArgumentException("사다리의 너비는 균일해야합니다.");
    }
  }
}
