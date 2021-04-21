package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Ladder {

  private final List<Line> lines;

  public Ladder(LadderHeight ladderHeight, LineCreationStrategy lineCreationStrategy, int personCount) {
    this.lines = createLines(lineCreationStrategy, ladderHeight, personCount);
  }

  public List<Line> createLines(final LineCreationStrategy lineCreationStrategy, LadderHeight ladderHeight,
      int personCount) {

    return Stream.generate(() -> new Line(lineCreationStrategy, personCount))
        .limit(ladderHeight.toInt())
        .collect(Collectors.toList());
  }

  public List<Line> lines() {
    return Collections.unmodifiableList(lines);
  }

  public GameResults gameResults(People people, List<Result> results) {
    final List<Person> personList = people.personList();
    final List<Result> gameResults = getGameResults(results, personList);

    return new GameResults(IntStream.range(0, Math.min(people.personCount(), results.size()))
        .boxed()
        .collect(Collectors.toMap(personList::get, gameResults::get)));
  }

  private List<Result> getGameResults(List<Result> results, List<Person> people) {
    return people.stream()
        .map(person -> findResultIndex(people, person))
        .map(results::get)
        .collect(Collectors.toList());
  }

  private int findResultIndex(final List<Person> people, final Person person) {
    int resultIndex = people.indexOf(person);
    for (Line line : lines) {
      resultIndex = line.nextPointIndex(resultIndex);
    }
    return resultIndex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Ladder ladder = (Ladder) o;
    return Objects.equals(lines, ladder.lines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lines);
  }
}
