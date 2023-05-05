package ladder.domain;

@FunctionalInterface
public interface MoveStrategy {
  boolean movable();
}
