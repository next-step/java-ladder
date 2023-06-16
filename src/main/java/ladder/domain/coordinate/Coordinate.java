package ladder.domain.coordinate;

public class Coordinate implements Determinable<Coordinate>{

  protected Coordinate(int value) {
    this.value = value;
  }

  private final int value;

  @Override
  public boolean isAdjacent(Coordinate other) {
    return Math.abs(this.value - other.value) <= 1;
  }

  @Override
  public boolean isSame(Coordinate other) {
    return equals(other);
  }

  @Override
  public boolean isGraterThan(Coordinate other) {
    return this.value > other.value;
  }

  @Override
  public int valueOf() {
    return this.value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Column otherColumn = (Column) o;
    return this.hashCode() == otherColumn.hashCode();
  }

  @Override
  public int hashCode() {
    return value;
  }
}
