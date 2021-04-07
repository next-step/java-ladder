package nextstep.ladder.domain;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.exception.PersonCountTooLowException;

public final class Line {

  public static final int MIN_PERSON_COUNT = 2;

  private final List<Point> points;

  public Line(final int countOfPerson, final LineCreationStrategy lineCreationStrategy) {
    this(countOfPerson, lineCreationStrategy.create());
  }

  public Line(final int countOfPerson, final List<Point> points) {
    validatePersonCount(countOfPerson);
    this.points = points;
  }

  private void validatePersonCount(final int countOfPerson) {
    if (countOfPerson < MIN_PERSON_COUNT) {
      throw new PersonCountTooLowException();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Line)) {
      return false;
    }
    Line line = (Line) o;
    return Objects.equals(points, line.points);
  }

  @Override
  public int hashCode() {
    return Objects.hash(points);
  }
}
