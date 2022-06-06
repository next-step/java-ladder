package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

  private static final int START_INDEX = 0;
  private static final int FIRST_LINE_POINT = 0;
  private static final int SECOND_LINE_POINT = 1;

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

  public int move(int playerIndex) {
    int nextIndex = lines.get(FIRST_LINE_POINT).move(playerIndex);
    for (int i = SECOND_LINE_POINT; i < lines.size(); i++) {
      nextIndex = lines.get(i).move(nextIndex);
    }
    return nextIndex;
  }
}
