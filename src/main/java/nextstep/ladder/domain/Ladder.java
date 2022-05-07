package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private final List<Line> lines = new ArrayList<>();

  public Ladder(Length width, Length height) {
    for (int i = 0; i < height.getValue(); i++) {
      lines.add(new Line(width.getValue()));
    }
  }
}
