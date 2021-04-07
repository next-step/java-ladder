package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Ladder {

  private final LadderHeight ladderHeight;
  private final People people;
  private final List<Line> lines;

  public Ladder(final int height, final String[] names) {
    this(new LadderHeight(height), new People(names), new ArrayList<>());
  }

  public Ladder(LadderHeight ladderHeight, People people, List<Line> lines) {
    this.ladderHeight = ladderHeight;
    this.people = people;
    this.lines = lines;
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
    return Objects.equals(ladderHeight, ladder.ladderHeight) && Objects.equals(people, ladder.people)
        && Objects.equals(lines, ladder.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ladderHeight, people, lines);
  }
}
