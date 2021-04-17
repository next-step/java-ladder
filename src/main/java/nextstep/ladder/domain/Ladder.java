package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Ladder {

  private final People people;
  private final List<Line> lines;

  public Ladder(People people, LadderHeight ladderHeight, LineCreationStrategy lineCreationStrategy) {
    this.people = people;
    this.lines = createLines(lineCreationStrategy, ladderHeight);
  }

  public List<Line> createLines(final LineCreationStrategy lineCreationStrategy,
      LadderHeight ladderHeight) {
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

  public int findResultIndex(final Person person) {
    final int personIndex = people.indexOf(person);
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Ladder)) {
      return false;
    }
    Ladder ladder = (Ladder) o;
    return Objects.equals(people, ladder.people) && Objects.equals(lines, ladder.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(people, lines);
  }
}
