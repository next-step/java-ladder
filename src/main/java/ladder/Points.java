package ladder;

import java.util.ArrayList;
import java.util.List;

public class Points {

  List<Boolean> positions = new ArrayList<>();

  public Points(int playerCount) {
    makeLine(playerCount);
  }

  private void makeLine(int playersCount) {
    firstPositionMakeLine();
    for (int i = 1; i < playersCount - 1; i++) {
      otherPositionMakeLine(i);
    }
  }

  private void firstPositionMakeLine() {
    positions.add(RandomStrategyMaker.make(false));
  }

  private void otherPositionMakeLine(int index) {
    if (hasBeforePositionLine(index)) {
      positions.add(false);
      return;
    }
    positions.add(RandomStrategyMaker.make(hasBeforePositionLine(index)));
  }

  private boolean hasBeforePositionLine(int position) {
    return positions.get(position - 1);
  }

  public LineDisplay draw() {
    return new LineDisplay(positions);
  }

  public int count() {
    return positions.size();
  }
}
