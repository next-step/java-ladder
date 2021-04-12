package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Ladder {

  private final People people;
  private final LadderHeight ladderHeight;
  private final List<Line> lines;

  public Ladder(People people, LadderHeight ladderHeight, LineCreationStrategy lineCreationStrategy) {
    this.ladderHeight = ladderHeight;
    this.people = people;
    this.lines = createLines(lineCreationStrategy);
  }

  public List<Line> createLines(final LineCreationStrategy lineCreationStrategy) {
    List<Line> lines = new ArrayList<>();
    for (int i = 0; i < ladderHeight.toInt(); i++) {
      lines.add(new Line(lineCreationStrategy, people.personCount()));
    }
    return lines;
  }

  public List<Line> lines() {
    return Collections.unmodifiableList(lines);
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
