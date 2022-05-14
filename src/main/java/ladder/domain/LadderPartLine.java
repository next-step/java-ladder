package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderPartLine {

  private final List<LadderPart> ladderParts;

  private LadderPartLine(List<LadderPart> ladderParts) {
    this.ladderParts = ladderParts;
  }

  public static LadderPartLine of(List<Boolean> isConnects) {
    List<LadderPart> parts = IntStream.range(0, isConnects.size())
        .mapToObj(i -> new LadderPart())
        .collect(Collectors.toList());

    for (int width = 0; width < parts.size() - 1; width++) {
      connect(parts.get(width), parts.get(width + 1), isConnects.get(width));
    }
    return new LadderPartLine(parts);
  }

  private static void connect(LadderPart left, LadderPart right, Boolean connect) {
    if (connect) {
      left.connectRight();
      right.connectLeft();
    }
  }

  public boolean isRightConnect(int lineIdx) {
    return ladderParts.get(lineIdx).isRightConnect();
  }

  public boolean isLeftConnect(int lineIdx) {
    return ladderParts.get(lineIdx).isLeftConnect();
  }

  public int getLadderWidth() {
    return ladderParts.size();
  }
}
