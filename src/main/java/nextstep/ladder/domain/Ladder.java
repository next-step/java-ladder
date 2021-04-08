package nextstep.ladder.domain;

import java.util.Objects;

public final class Ladder {

  private final LadderHeight ladderHeight;
  private final People people;
  private final Lines lines;

  public Ladder(LadderHeight ladderHeight, People people) {
    this(ladderHeight, people, new LadderLines(ladderHeight, people));

  }

  public Ladder(LadderHeight ladderHeight, People people, Lines lines) {
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
