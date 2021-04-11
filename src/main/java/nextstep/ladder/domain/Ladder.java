package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class Ladder {

  private final LadderHeight ladderHeight;
  private final People people;

  public Ladder(LadderHeight ladderHeight, People people) {
    this.ladderHeight = ladderHeight;
    this.people = people;
  }

  public People people() {
    return people;
  }

  public List<Line> lines() {
    return Collections
        .unmodifiableList(new LadderLines(ladderHeight, new PersonCount(people.personList().size())).lines());
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
    return Objects.equals(ladderHeight, ladder.ladderHeight) && Objects.equals(people, ladder.people);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ladderHeight, people);
  }
}
