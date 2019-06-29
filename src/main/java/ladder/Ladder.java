package ladder;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  List<Line> ladder = new ArrayList<>();

  public Ladder(int lineHeight, int playerCount) {
    makeLine(lineHeight, playerCount);
  }

  private void makeLine(int lineHeight, int playerCount) {
    for (int i = 0; i < lineHeight; i++) {
      ladder.add(new Line(playerCount));
    }
  }

  public int getHeight() {
    return ladder.size();
  }

  public LadderDisplay draw() {
    return new LadderDisplay(ladder.stream()
        .map(Line::draw)
        .collect(toList()));
  }

}
