package ladder;

import java.util.ArrayList;
import java.util.List;

public class Lines {

  List<Line> lines = new ArrayList<>();

  public Lines(LadderGameInformation ladderGameInformation) {
    makeLine(ladderGameInformation.ladderHeight(),ladderGameInformation.playersCount());
  }

  private void makeLine(int lineHeight, int playerCount) {
    for (int i = 0; i < lineHeight; i++) {
      lines.add(new Line(playerCount));
    }
  }

  public int getHeight() {
    return lines.size();
  }
}
