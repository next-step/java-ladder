package nextstep.ladder.domain;

public final class RandomLineCreationStrategy implements LineCreationStrategy {

  @Override
  public boolean canCreate() {
    return false;
  }
}
