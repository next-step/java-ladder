package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class LadderLines {

  private final LadderHeight ladderHeight;
  private final People people;

  public LadderLines(LadderHeight ladderHeight, People people) {
    this.ladderHeight = ladderHeight;
    this.people = people;
  }

  public List<Line> lines(final LineCreationStrategy lineCreationStrategy) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < ladderHeight.toInt(); i++) {
      lines.add(new Line(lineCreationStrategy));
    }
    return lines;
  }

  public People people() {
    return people;
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
    return Objects.equals(ladderHeight, that.ladderHeight) && Objects.equals(people, that.people);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ladderHeight, people);
  }
}
