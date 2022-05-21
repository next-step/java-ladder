package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderPartLines {

  private final List<LadderPartLine> lines;

  public LadderPartLines(List<LadderPartLine> ladderLines) {
    this.lines = ladderLines;
  }

  public static LadderPartLines of(int height, int width) {
    List<LadderPartLine> ladderPartLines = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      ladderPartLines.add(LadderPartLine.from(width));
    }

    return new LadderPartLines(ladderPartLines);
  }

  public int height() {
    return lines.size();
  }

  public int traverse(int startIndex) {
    int result = startIndex;
    for (LadderPartLine line : lines) {
      result = line.move(result);
    }
    return result;
  }

  public List<LadderPartLine> getLines() {
    return lines;
  }

  public int getWidth() {
    return lines.get(0).getWidth();
  }

  public Connect getConnect(int heightIdx, int lineIdx) {
    return lines.get(heightIdx).getConnect(lineIdx);
  }
}
