package ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  List<Line> ladder = new ArrayList<>();

  public Ladder(LadderGameInformation ladderGameInformation) {
    makeLine(ladderGameInformation.ladderHeight(),ladderGameInformation.playersCount());
  }

  private void makeLine(int lineHeight, int playerCount) {
    for (int i = 0; i < lineHeight; i++) {
      ladder.add(new Line(playerCount));
    }
  }

  public int getHeight() {
    return ladder.size();
  }
}
