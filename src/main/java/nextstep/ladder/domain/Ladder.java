package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

  private static final int START_INDEX = 0;

  private final List<Line> lines = new ArrayList<>();

  Ladder(Length width, Length height) {
    for (int i = START_INDEX; i < height.getValue(); i++) {
      lines.add(Line.create(width.getValue(), HalfBooleanGeneratingStrategy.getInstance()));
    }
  }

  public static Ladder of(int width, int height) {
    return new Ladder(new Length(width), new Length(height));
  }

  public int getWidth() {
    return lines.get(START_INDEX).size();
  }

  public int getHeight() {
    return lines.size();
  }

  public List<Line> getLines() {
    return lines;
  }
}
