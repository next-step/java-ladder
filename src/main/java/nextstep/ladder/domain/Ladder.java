package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Ladder {

  private final People people;
  private final LadderHeight ladderHeight;

  public Ladder(People people, LadderHeight ladderHeight) {
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
    if (!(o instanceof Ladder)) {
      return false;
    }
    Ladder that = (Ladder) o;
    return Objects.equals(ladderHeight, that.ladderHeight) && Objects.equals(people, that.people);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ladderHeight, people);
  }
}
