package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class LadderLines implements Lines {

  private final LadderHeight ladderHeight;
  private final PersonCount personCount;

  public LadderLines(int height, String[] names) {
    this(new LadderHeight(height), new PersonCount(names.length));
  }

  public LadderLines(LadderHeight ladderHeight, PersonCount personCount) {
    this.ladderHeight = ladderHeight;
    this.personCount = personCount;
  }

  @Override
  public List<Line> lines() {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < ladderHeight.toInt(); i++) {
      lines.add(new Line(personCount, new RandomLineCreationStrategy()));
    }
    return lines;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LadderLines)) {
      return false;
    }
    LadderLines that = (LadderLines) o;
    return Objects.equals(ladderHeight, that.ladderHeight) && Objects
        .equals(personCount, that.personCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ladderHeight, personCount);
  }
}
