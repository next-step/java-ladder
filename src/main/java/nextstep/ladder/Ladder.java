package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private final List<Line> lines;

  public Ladder(int height, int countOfPlayers, DirectionStrategy strategy) {
    this.lines = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      lines.add(new Line(countOfPlayers, strategy));
    }
  }

  public List<Line> getLines() {
    return lines;
  }
}
