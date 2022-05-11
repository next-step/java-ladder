package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private final List<Line> lines = new ArrayList<>();

  Ladder(Length width, Length height) {
    for (int i = 0; i < height.getValue(); i++) {
      lines.add(Line.of(width.getValue()));
    }
  }

  public static Ladder of(int width, int height) {
    return new Ladder(new Length(width), new Length(height));
  }

  public int getWidth() {
    return lines.get(0).size();
  }

  public int getHeight() {
    return lines.size();
  }

  public List<Line> getLines() {
    return lines;
  }
}
