package nextstep.ladder.biz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

  private List<LadderLine> lines = new ArrayList<>();

  public Ladder(int countOfPerson, int ladderHeight) {
    for (int i = 0; i < ladderHeight; i++) {
      lines.add(LadderLine.init(countOfPerson));
    }
  }

  public List<LadderLine> getLines() {
    return Collections.unmodifiableList(lines);
  }

  public Chessmen play(Chessmen chessmen) {
    int result = chessmen.getLocation();
    for (LadderLine line : lines) {
      result = line.move(result);
    }

    return chessmen.move(result);
  }

  @Override
  public String toString() {
    return "Ladder{" +
            "lines=" + lines +
            '}';
  }
}
