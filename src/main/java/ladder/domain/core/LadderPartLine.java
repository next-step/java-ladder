package ladder.domain.core;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Connect;

public class LadderPartLine {

  private final List<LadderPart> line;

  public LadderPartLine(List<LadderPart> line) {
    this.line = line;
  }

  public static LadderPartLine from(int width) {
    List<LadderPart> partLine = new ArrayList<>();
    LadderPart first = LadderPart.first();
    partLine.add(first);

    LadderPart lastPart = addBody(width, partLine, first);

    addLast(width, partLine, lastPart);
    return new LadderPartLine(partLine);
  }

  private static void addLast(int width, List<LadderPart> partLine, LadderPart lastPart) {
    if (width > partLine.size()) {
      partLine.add(lastPart.last());
    }
  }

  private static LadderPart addBody(int width, List<LadderPart> partLine, LadderPart part) {
    for (int widthPoint = 1; widthPoint < width - 1; widthPoint++) {
      part = part.generateNext();
      partLine.add(part);
    }
    return part;
  }

  public int move(int lineIdx) {
    return line.get(lineIdx).move();
  }

  public int getWidth() {
    return line.size();
  }

  public boolean isRightConnect(int lineIdx) {
    return line.get(lineIdx).isRightConnect();
  }
}
