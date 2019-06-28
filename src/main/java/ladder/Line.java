package ladder;

import java.util.List;

public class Line {

  List<Boolean> positions;

  public Line(int playersCount) {
    makeLine(playersCount);
  }

  private void makeLine(int playersCount) {
    firstPositionMakeLine();
    otherPositionMakeLine(playersCount);
  }

  private void firstPositionMakeLine() {
    positions.add(RandomStrategyMaker.make(false));
  }

  private void otherPositionMakeLine(int playersCount) {
    for (int i = 1; i < playersCount - 1; i++) {
      positions.add(RandomStrategyMaker.make(hasBeforePositionLine(i)));
    }
  }

  private boolean hasBeforePositionLine(int position) {
    return positions.get(position - 1);
  }

}
