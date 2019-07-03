package ladder.util;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Players;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {

  public static Lines generate(int height, Players players) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      lines.add(Line.of(players));
    }
    return Lines.of(lines);
  }

}
