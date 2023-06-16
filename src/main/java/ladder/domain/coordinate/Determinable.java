package ladder.domain.coordinate;

public interface Determinable<T> {

  boolean isAdjacent(T other);

  boolean isSame(T other);

  boolean isGraterThan(T other);

  int valueOf();
}
