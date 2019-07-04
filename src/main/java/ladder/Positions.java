package ladder;

import java.util.ArrayList;
import java.util.List;

public class Positions {

  List<Boolean> positions = new ArrayList<>();

  public Positions(int playerCount) {
    makeLine(playerCount);
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

  public LineDisplay draw() {
    return new LineDisplay(positions);
  }

  public int count() {
    return positions.size();
  }
}
