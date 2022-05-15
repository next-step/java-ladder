package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

  private static final int START_INDEX = 0;

  private final List<Line> lines = new ArrayList<>();

  Ladder(List<Line> values) {
    this.lines.addAll(values);
  }

  public static Ladder of(Length width, Length height) {
    List<Line> createdLines = new ArrayList<>();
    for (int i = START_INDEX; i < height.getValue(); i++) {
      createdLines.add(Line.create(width.getValue(), HalfRateGeneratingStrategy.getInstance()));
    }
    return new Ladder(createdLines);
  }

  public int getWidth() {
    return lines.get(START_INDEX).size();
  }

  public int getHeight() {
    return lines.size();
  }

  public List<Line> getLines() {
    return Collections.unmodifiableList(lines);
  }
}
